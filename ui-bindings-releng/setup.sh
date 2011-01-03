#!/bin/bash
#
#    Copyright (c) 2010 Torkild U. Resheim
#    All rights reserved. This program and the accompanying materials
#    are made available under the terms of the Eclipse Public License v1.0
#    which accompanies this distribution, and is available at
#    http://www.eclipse.org/legal/epl-v10.html
#   
#    Contributors:
#        Torkild U. Resheim - initial API and implementation
#

# This script is used to set up continous building of an Eclipse application
# using Hudson and various plug-ins to this.

# Todo: Prepare base-location automatically
export BASE_LOCATION=/Users/torkild/Development/Build/BaseLocations/Eclipse_3.6

# The project name
PROJECT="Buildmonitor"
# Root URL for downloading p2 repositories to compile against
#ROOT_URL=http://download.eclipse.org
ROOT_URL=ftp://ftp.uninett.no/pub/eclipse
EMMA_URL="http://downloads.sourceforge.net/project/emma/emma-release/2.0.5312/emma-2.0.5312-lib.zip?use_mirror=ignum&ts=1278950538"
# Default wget options
WGET_OPTS="--no-clobber --progress=bar"
# Find a place for the p2 repositories if required
if [ -n "${BASE_REPOS}+x" ] ; then
	echo Using base repository location at $BASE_REPOS
else	
	export BASE_REPOS=`pwd`/repos
fi
# Create folder for build repository
if [ ! -d $BASE_REPOS ]
	then mkdir $BASE_REPOS
fi
# Find a place for old fashioned update sites
if [ -n "${UPDATESITES}+x" ] ; then
	echo Using update site location at $UPDATESITES
else	
	export UPDATESITES=`pwd`/sites
fi
# Create folder for build repository
if [ ! -d $UPDATESITES ]
	then mkdir $UPDATESITES
fi
# Find a place for the p2 repositories if required
if [ -n "${TRANSFORMED_REPOS}+x" ] ; then
	echo Using transformed repository location at $TRANSFORMED_REPOS
else	
	export TRANSFORMED_REPOS=`pwd`/transformedRepos
fi
# Helper function for downloading files and making sure that the process
# succeeded.
function download {
	wget $WGET_OPTS $1
	if [ $? -ne 0 ] ; then
		FILE=`echo $1 | sed 's|.*/||'`
		if [ -e "$FILE" ] ; then
			return 0
		fi
		echo "ERROR: Could not download " $FILE
		kill $$;
	fi
}
# Downloads and installs a Hudson plug-in. The name of the plug-in
# must be given as the first argument.
function installPlugin {	
#	if [ ! -e $HUDSON_HOME/plugins/$1.hpi ] ; then 
		pushd $HUDSON_HOME/plugins/
		download http://hudson-ci.org/latest/$1.hpi 
		popd
#	fi
}
# Download the various Equinox p2 repositories we need
pushd $BASE_REPOS
download $ROOT_URL/eclipse/downloads/drops/R-3.6-201006080911/org.eclipse.rcp-3.6.zip
download $ROOT_URL/eclipse/downloads/drops/R-3.6-201006080911/org.eclipse.cvs-3.6.zip
download $ROOT_URL/eclipse/downloads/drops/R-3.6-201006080911/org.eclipse.platform-3.6.zip
popd
# Download Mylyn which does not come as an update site
pushd $UPDATESITES
download $ROOT_URL/tools/mylyn/update/mylyn-3.4.0-e3.4.zip
unzip -q -o mylyn-3.4.0-e3.4.zip -d $UPDATESITES/eclipse
popd
# Shut down the running Hudson if we have one
if [ -e hudson.pid ] ; then
  pid=`cat hudson.pid`
  kill -15 $pid
  rm hudson.pid
fi
# Find a place for Hudson if required
if [ -n "${HUDSON_HOME}+x" ] ; then
	echo Using Hudson directory at $HUDSON_HOME
else	
	export HUDSON_HOME=./server
fi
# Create folder for Hudson
if [ ! -d $HUDSON_HOME ]
	then mkdir $HUDSON_HOME
fi
# Find a place for ANT libraries if required
if [ "${ANT_LIBS}+x" ] ; then
	export ANT_LIBS=`pwd`/ant_libs
fi
# Create folder for ANT libraries
if [ ! -d $ANT_LIBS ]
	then mkdir $ANT_LIBS
fi
# Download Google Code ANT task
if [ ! -e $ANT_LIBS/ant-googlecode-0.0.2.jar ]
	then wget http://ant-googlecode.googlecode.com/files/ant-googlecode-0.0.2.jar \
	-O $ANT_LIBS/ant-googlecode-0.0.2.jar 
fi	
# Download Emma
if [ ! -e $ANT_LIBS/emma.jar -o ! -e $ANT_LIBS/emma_ant.jar  ]; then 
	wget $EMMA_URL \-O $ANT_LIBS/emma-2.0.5312-lib.zip
	unzip -o $ANT_LIBS/emma-2.0.5312-lib.zip -d $ANT_LIBS
	rm $ANT_LIBS/emma-2.0.5312-lib.zip
fi	
# Download Hudson
if [ ! -e $HUDSON_HOME/hudson.war ]
	then wget http://hudson-ci.org/latest/hudson.war -O $HUDSON_HOME/hudson.war 
fi
# Create a place for plug-ins if it's not there
if [ ! -d $HUDSON_HOME/plugins ]
	then mkdir $HUDSON_HOME/plugins
fi
# Download and install Hudson plug-ins
installPlugin mercurial
installPlugin analysis-core
installPlugin warnings
installPlugin promoted-builds
installPlugin emma
# Create a place for jobs
if [ ! -d $HUDSON_HOME/jobs ]
	then mkdir $HUDSON_HOME/jobs
fi	
# Create a place for the  build job
if [ ! -d $HUDSON_HOME/jobs/$PROJECT ]
	then mkdir $HUDSON_HOME/jobs/$PROJECT
fi	
# Create a place for the "Stable" promotion
if [ ! -d $HUDSON_HOME/jobs/$PROJECT/promotions ]
	then mkdir $HUDSON_HOME/jobs/$PROJECT/promotions
fi	
if [ ! -d $HUDSON_HOME/jobs/$PROJECT/promotions/Stable ]
	then mkdir $HUDSON_HOME/jobs/$PROJECT/promotions/Stable
fi	
# Create the job description file
pushd ../
REPO_PATH=`pwd`
# Obtain the Google Code password 
hgrc=`cat .hg/hgrc`
GC_LOGIN=`expr "$hgrc" : ".*//\([^:]*\)"`
GC_PASSWORD=`expr "$hgrc" : ".*:\([^@]*\)"`
popd
LAUNCHER_JAR=`find "$ECLIPSE_HOME/plugins" -name "org.eclipse.equinox.launcher_*.jar" | tail -n 1`
PDE_HOME=`find "$ECLIPSE_HOME/plugins" -name "org.eclipse.pde.build_*" | tail -n 1`
BUILDFILE=`echo $PDE_HOME/scripts/productBuild/productBuild.xml`
sed "s|REPO_PATH|$REPO_PATH|g" hudson-job-template.xml \
	| sed "s|LAUNCHER_JAR|$LAUNCHER_JAR|g" \
	| sed "s|ECLIPSE_HOME|$ECLIPSE_HOME|g" \
	| sed "s|BASE_LOCATION|$BASE_LOCATION|g" \
	| sed "s|BUILDFILE|$BUILDFILE|g" \
	| sed "s|ANT_LIBS|$ANT_LIBS|g" \
	| sed "s|BASE_REPOS|$BASE_REPOS|g" \
	| sed "s|TRANSFORMED_REPOS|$TRANSFORMED_REPOS|g" \
	| sed "s|UPDATESITES|$UPDATESITES|g" \
	> $HUDSON_HOME/jobs/$PROJECT/config.xml
sed "s|REPO_PATH|$REPO_PATH|g" hudson-promote-template.xml \
	| sed "s|LAUNCHER_JAR|$LAUNCHER_JAR|g" \
	| sed "s|ECLIPSE_HOME|$ECLIPSE_HOME|g" \
	| sed "s|BASE_LOCATION|$BASE_LOCATION|g" \
	| sed "s|BUILDFILE|$BUILDFILE|g" \
	| sed "s|GC_LOGIN|$GC_LOGIN|g" \
	| sed "s|GC_PASSWORD|$GC_PASSWORD|g" \
	| sed "s|ANT_LIBS|$ANT_LIBS|g" \
	> $HUDSON_HOME/jobs/$PROJECT/promotions/Stable/config.xml
# Start the Hudson server
java -jar $HUDSON_HOME/hudson.war #&
#echo $! > hudson.pid


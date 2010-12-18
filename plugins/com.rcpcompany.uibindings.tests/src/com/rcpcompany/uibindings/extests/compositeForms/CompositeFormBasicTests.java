package com.rcpcompany.uibindings.extests.compositeForms;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.rcpcompany.uibindings.compositeform.AbstractCompositeFormPartFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormManager;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations;

/**
 * Tests of the basics for {@link ICompositeFormManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CompositeFormBasicTests {
	/**
	 * Tests that the manager is unique.
	 */
	@Test
	public void testUnique() {
		final ICompositeFormManager m1 = ICompositeFormManager.Factory.getManager();
		assertNotNull(m1);

		final ICompositeFormManager m2 = ICompositeFormManager.Factory.getManager();
		assertEquals(m2, m1);
	}

	@Test
	public void testReader() {
		final ICompositeFormManager m = ICompositeFormManager.Factory.getManager();

		final EList<ICompositeFormDescriptor> forms = m.getForms();
		assertNotNull(forms);
		assertEquals(2, forms.size());

		ICompositeFormDescriptor fd = null;

		for (final ICompositeFormDescriptor f : forms) {
			if ("com.rcpcompany.uibindings.tests.compositeForms.form1".equals(f.getId())) {
				fd = f;
				break;
			}
		}
		assertNotNull(fd);

		assertEquals("com.rcpcompany.uibindings.tests.compositeForms.form1", fd.getId());

		final EList<ICompositeFormPartDescriptor> parts = fd.getParts();
		assertNotNull(parts);
		assertEquals(3, parts.size());

		final ICompositeFormPartDescriptor pTop = parts.get(0);
		assertNotNull(pTop);
		assertEquals("Top", pTop.getTitle());
		assertNotNull(pTop.getImage().getImage());
		assertEquals(1000, pTop.getPriority());
		final ICompositeFormPartFactory pTopFactory = pTop.getFactory().getObject();
		assertNotNull(pTopFactory);

		final ICompositeFormPartDescriptor pMiddle = parts.get(1);
		assertNotNull(pMiddle);
		assertEquals("Middle", pMiddle.getTitle());
		assertNotNull(pMiddle.getImage().getImage());
		assertEquals(100, pMiddle.getPriority());
		final ICompositeFormPartFactory pMiddleFactory = pMiddle.getFactory().getObject();
		assertNotNull(pMiddleFactory);

		final ICompositeFormPartDescriptor pBotton = parts.get(2);
		assertNotNull(pBotton);
		assertEquals("Botton", pBotton.getTitle());
		assertNotNull(pBotton.getImage().getImage());
		assertEquals(1, pBotton.getPriority());
		final ICompositeFormPartFactory pBottonFactory = pBotton.getFactory().getObject();
		assertNotNull(pBottonFactory);
	}

	public static class TopFactory extends AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {
		@Override
		public ICompositeFormPartOperations create(ICompositeFormPart part) {
			final ICompositeFormPartDescriptor descriptor = part.getDescriptor();
			assertEquals("Top", descriptor.getTitle());
			return null;
		}
	}

	public static class MiddleFactory extends AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {
		@Override
		public ICompositeFormPartOperations create(ICompositeFormPart part) {
			final ICompositeFormPartDescriptor descriptor = part.getDescriptor();
			assertEquals("Middle", descriptor.getTitle());
			return null;
		}
	}

	public static class BottonFactory extends AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {
		@Override
		public ICompositeFormPartOperations create(ICompositeFormPart part) {
			final ICompositeFormPartDescriptor descriptor = part.getDescriptor();
			assertEquals("Botton", descriptor.getTitle());
			return null;
		}
	}
}

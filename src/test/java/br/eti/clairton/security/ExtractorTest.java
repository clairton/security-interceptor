package br.eti.clairton.security;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.eti.clairton.security.another.pack.SaleController;

public class ExtractorTest {
	private final Extractor extractor = new Extractor();

	@Test
	public void testGetOperation() {
		extractor.getResource(new AplicacaoController());
	}

	@Test
	public void testTypeWithMethodAnotated() {
		assertEquals("aplicacao",
				extractor.getResource(new AplicacaoController()));
	}

	@Test
	public void testByType() {
		assertEquals("sale", extractor.getResource(SaleController.class));
	}

	@Test
	public void testTypeAnotated() {
		assertEquals("sale", extractor.getResource(new SaleController("asdf")));
	}

	@Test(expected = IllegalStateException.class)
	public void testTypeAnotatedIncorret() {
		extractor.getResource(new IncorrectTypeAnnotatedController());
	}

	@Test(expected = IllegalStateException.class)
	public void testMethodWithReturnNotString() {
		extractor.getResource(new IncorrectMethodAnnotatedController());
	}

	@Test
	public void testTypeWihoutAnotated() {
		assertEquals("wihoutAnotated", extractor.getResource(new WihoutAnotatedController4_464Hsdf()));
	}

	@Test
	public void testTypeProxy() {
		assertEquals("proxyAble", extractor.getResource(new ProxyAble$Proxy$kasdbshj()));
	}
}

@Resource()
class IncorrectTypeAnnotatedController {

}

class IncorrectMethodAnnotatedController {

	@Resource
	public SaleController test() {
		return new SaleController("");
	}
}

class WihoutAnotatedController4_464Hsdf{}

class ProxyAble$Proxy$kasdbshj{}
class ProxyAble{}


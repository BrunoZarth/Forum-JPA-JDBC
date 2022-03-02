//import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import static junit.framework.Assert.assertEquals;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;




public class Teste {
        String senhaBancoDeDados = "tartarugo:le";
	JdbcDatabaseTester jdt;
	
	@Before
	public void setup() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}
	
	@Test
	public void inserirTest() throws SQLException, Exception {
		BancoDeDados db = new BancoDeDados();
		Usuario u = new Usuario("xuraingous", "xuraingous@xura.com", "Xuraingous", "xura", 15);
		db.inserir(u);
		
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataSet.getTable("USUARIO");
		
		Assertion.assertEquals(expectedTable, currentTable);
	}
	
	@Test
	public void recuperarTest() {
		BancoDeDados db = new BancoDeDados();
		String usuario = db.recuperar("etevas").toString();
		assertEquals(usuario, "Usuario{login=etevas, email=etevaldo@peixoto.com, nome=etevaldo, senha=blugblug, pontos=7}");
	}
	
	@Test
	public void adicionarPontosTest() throws SQLException, Exception {
		BancoDeDados db = new BancoDeDados();
		db.adicionarPontos("xeraingous", 5);
		
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verificaPontos.xml");
		ITable expectedTable = expectedDataSet.getTable("USUARIO");
		
		Assertion.assertEquals(expectedTable, currentTable);
	}
	
	@Test
	public void rankingTest() {
		BancoDeDados db = new BancoDeDados();
		String expected = "[Usuario{login=etevas, email=etevaldo@peixoto.com, nome=etevaldo, senha=blugblug, pontos=7}, Usuario{login=astro, email=astrogildo@peixoto.com, nome=astrogildo, senha=glubglub, pontos=5}]";
		String ranking = db.ranking().toString();
		
		assertEquals(expected, ranking);
	}

}
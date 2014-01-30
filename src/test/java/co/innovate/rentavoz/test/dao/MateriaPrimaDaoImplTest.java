package co.innovate.rentavoz.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.innovate.rentavoz.test.BaseUnit;

import com.formiplass.sipro.model.MateriaPrima;
import com.formiplass.sipro.repositories.MateriaPrimaDao;

public class MateriaPrimaDaoImplTest  extends BaseUnit{

	@Autowired
	private MateriaPrimaDao materiaPrimaDao;
	@Test
	public void test() {
List<MateriaPrima> lista= materiaPrimaDao.findAll();
Assert.assertNotNull(lista);
	}

}

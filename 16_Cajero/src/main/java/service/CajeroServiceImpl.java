package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CajeroServiceImpl implements CajeroService {

	@Autowired
	ConversorEntityDto conversor;
	
	ClientesDao clientesDao;
	CuentasDao cuentasDao;
	MovimientosDao movimientosDao;
	
	
	public CajeroServiceImpl(ClientesDao clientesDao, CuentasDao cuentasDao, MovimientosDao movimientosDao) {
		this.clientesDao = clientesDao;
		this.cuentasDao = cuentasDao;
		this.movimientosDao = movimientosDao;
	}


	@Override
	public CuentaDto obtenerCuenta(int numCuenta) {
		Optional<Cuenta> cuentas = cuentasDao.findById(numCuenta);
		
		if (!cuentas.isEmpty()) {
			return conversor.cuentaToDto(cuentas.get());
		}
		
		return null;
	}
	
	
	@Override
	public boolean ingresarDinero(int numCuenta, double cantidad) {
		Optional<Cuenta> cuentas = cuentasDao.findById(numCuenta);

		if (!cuentas.isEmpty()) {
			Cuenta c = cuentas.get();
			double saldo = c.getSaldo();
					
			saldo+= cantidad;
			c.setSaldo(saldo);
			
			Movimiento m = new Movimiento( numCuenta, new Date(), cantidad , "ingreso");
			
			cuentasDao.save(c);
			movimientosDao.save(m);
			
			return true;
		}
		return false;
			
	}

	@Override
	public boolean extraerDinero(int numCuenta, double cantidad) {
		Optional<Cuenta> cuentas = cuentasDao.findById(numCuenta);
		
		if (!cuentas.isEmpty()) {
			Cuenta c = cuentas.get();
			double saldo = c.getSaldo();
			
			saldo -= cantidad;
			c.setSaldo(saldo);
			
			Movimiento m = new Movimiento( numCuenta, new Date(), cantidad , "extracción");
			
			cuentasDao.save(c);
			movimientosDao.save(m);
			
			return true;
		}
		return false;
	}



	@Override
	public boolean transferencia(int nCuentaOrg, int nCuentaDst, double cantidad) {
		Optional<Cuenta> cuentaOrg = cuentasDao.findById(nCuentaOrg);
		Optional<Cuenta> cuentaDst = cuentasDao.findById(nCuentaDst);

		if (!cuentaOrg.isEmpty() && !cuentaDst.isEmpty()) {
			extraerDinero(nCuentaOrg,cantidad);
			ingresarDinero(nCuentaDst, cantidad);
		}
		return false;
	}


	@Override
	public List<MovimientoDto> movimientos(int numCuenta, Date f1, Date f2) {
		return movimientosDao.findByIdCuentaAndFechaBetween(numCuenta,f1, f2)
				.stream()
				.map(m->conversor.movimientoToDto(m))
				.collect(Collectors.toList());
	}


	@Override
	public double verSaldo(int numCuenta) {
		Optional<Cuenta> cuenta = cuentasDao.findById(numCuenta);
		if (!cuenta.isEmpty()) {
			return cuenta.get().getSaldo();
		}
			
		return 0.0;
	}


}


package test.solidityunit;

import org.junit.runner.RunWith;

import experiments.contracts.Democracy;
import solidityunit.annotations.Contract;
import solidityunit.runner.SolidityUnitRunner;

@RunWith(SolidityUnitRunner.class)
public class TestDemocracy {

	@Contract
	Democracy democracy;
	
}

package test.solidityunit;

import org.junit.Before;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import experiments.contracts.Democracy;

public class TestDemocracyWithout {

	private Web3j web3j;
	private Credentials mainCredentials;
	
	Democracy democracy;
	
	@Before
	public void setUp() throws Exception {
		web3j = Web3j.build(new HttpService("http://localhost:7545"));
		mainCredentials = Credentials.create("1234");
		democracy = Democracy.deploy(web3j, mainCredentials, 
									DefaultGasProvider.GAS_PRICE, 
									DefaultGasProvider.GAS_LIMIT)
								.send();
	}
	
}

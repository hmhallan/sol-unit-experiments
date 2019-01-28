package experiments.democracy;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.utils.Convert;

import experiments.contracts.Democracy;
import experiments.util.TransactionUtils;
import solidityunit.annotations.Account;
import solidityunit.runner.SolidityUnitRunner;

@RunWith(SolidityUnitRunner.class)
public class TestDemocracyWithout {

	private Web3j web3j;
	private Credentials mainCredentials;
	
	Democracy democracy;
	
//	@Before
//	public void setUp() throws Exception {
//		web3j = Web3j.build(new HttpService("http://localhost:8545"));
//		mainCredentials = Credentials.create("4fdea21d97d892af91c5120968cbd66e4b9cad23148ada6108ba0d4441b5fc98");
//		democracy = Democracy.deploy(web3j, mainCredentials, 
//									DefaultGasProvider.GAS_PRICE, 
//									DefaultGasProvider.GAS_LIMIT)
//								.send();
//	}
	
	@Account(id="main")
	Credentials mainAccount;
	
	@Account(id="1")
	Credentials account1;
	
	@Account(id="2")
	Credentials account2;
	
	@Account(id="3")
	Credentials account3;
	
	@Account(id="4")
	Credentials account4;
	
	@Test
	public void teste() throws Exception {
		
		Credentials c = WalletUtils.loadCredentials("hmhallan", new File("/home/hallan/desenvolvimento/ethereum/blockchain/keystore/UTC--2019-01-25T17-09-20.207909830Z--73b47860915e08625d4d92c6c1a0bd78a83c1be5"));
		System.out.println( c.getEcKeyPair().getPrivateKey().toString(16));
		
		System.out.println(
				TransactionUtils.sendToWallet(this.mainAccount, this.account3, 
						Convert.toWei("500", Convert.Unit.ETHER).toBigInteger() ).getTransactionHash()
		);
		
	}
	
}

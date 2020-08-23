const MetaCoin = artifacts.require("MetaCoin");

contract('MetaCoin', (accounts) => {

  beforeEach(async () => {
    const metaCoinInstance = await MetaCoin.deployed();
    metaCoinInstance.setInitialBalance();
  });

  it('should have balance in main account', async () => {
    const metaCoinInstance = await MetaCoin.deployed();
    const balance = await metaCoinInstance.getBalance.call(accounts[0]);

    assert.equal(balance.valueOf(), 10000, "10000 wasn't in the first account");
  });

  it('should have balance in main account in Eth', async () => {
    const metaCoinInstance = await MetaCoin.deployed();
    const balance = await metaCoinInstance.getBalanceInEth.call(accounts[0]);

    assert.equal(balance.valueOf(), 20000, "20000 wasn't in the first account");
  });

  
  it('should send coin correctly', async () => {
    const metaCoinInstance = await MetaCoin.deployed();

    // Setup 2 accounts.
    const accountOne = accounts[0];
    const accountTwo = accounts[1];

    // Make transaction from first account to second.
    const amount = 100;
    await metaCoinInstance.sendCoin(accountTwo, amount, { from: accountOne });

    // Get balances of first and second account after the transactions.
    const account1 = (await metaCoinInstance.getBalance.call(accountOne)).toNumber();
    const account2 = (await metaCoinInstance.getBalance.call(accountTwo)).toNumber();


    assert.equal(account1, 9900, "Amount wasn't correctly taken from the sender");
    assert.equal(account2, 100, "Amount wasn't correctly sent to the receiver");
  });
});

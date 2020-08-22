const Democracy = artifacts.require("Democracy");

contract('Democracy', (accounts) => {

    //armazena a instancia do contrato
    var d1;
    var account = accounts[0];

    const TOTAL_PROPOSALS = 5;
	
	const VOTE_FAVOR = 1;
	const VOTE_AGAINST = 2;

    const PROPOSAL_1 = 0;
	const PROPOSAL_2 = 1;
	const PROPOSAL_3 = 2;
	const PROPOSAL_4 = 3;
	const PROPOSAL_5 = 4;

   beforeEach(async () => {
       d1 = await Democracy.deployed();


       console.info("DEPLOY");

        for ( let i = 1; i <= TOTAL_PROPOSALS; i++ ) {

            await d1.createProposal.call("Proposal " + i, 
                                        "Description of proposal number  " + i, 
                                        (100 * i), 
                                        (100 * i) );
            //await sleep(1000);
            console.info("PROP " + i);
        }


        await d1.voteOnProposal.call(accounts[0], PROPOSAL_3, VOTE_FAVOR);
        await d1.voteOnProposal.call(accounts[0], PROPOSAL_2, VOTE_AGAINST);
        
        await d1.voteOnProposal.call(accounts[2], PROPOSAL_2, VOTE_AGAINST);
        await d1.voteOnProposal.call(accounts[2], PROPOSAL_3, VOTE_AGAINST);
        
        await d1.voteOnProposal.call(accounts[3], PROPOSAL_2, VOTE_FAVOR);
        
        await d1.voteOnProposal.call(accounts[0], PROPOSAL_4, VOTE_FAVOR);
        await d1.voteOnProposal.call(accounts[1], PROPOSAL_4, VOTE_FAVOR);
        await d1.voteOnProposal.call(accounts[2], PROPOSAL_4, VOTE_FAVOR);
        await d1.voteOnProposal.call(accounts[3], PROPOSAL_4, VOTE_FAVOR);
        await d1.voteOnProposal.call(accounts[4], PROPOSAL_4, VOTE_AGAINST);
        
        await d1.voteOnProposal.call(accounts[0], PROPOSAL_5, VOTE_AGAINST);
        await d1.voteOnProposal.call(accounts[1], PROPOSAL_5, VOTE_AGAINST);
        await d1.voteOnProposal.call(accounts[2], PROPOSAL_5, VOTE_AGAINST);
        await d1.voteOnProposal.call(accounts[3], PROPOSAL_5, VOTE_AGAINST);
        await d1.voteOnProposal.call(accounts[4], PROPOSAL_5, VOTE_FAVOR);

        console.info("rodei");

        const totalx = await d1.getProposalsLength.call();
        console.info("TOTAL:  " + totalx);

        //totais
        //proposta 2: 2 contra, 1 favor
        //proposta 3: 1 favor, 1 contra
        //proposta 4: 1 contra, 4 favor
        //proposta 5: 4 contra, 1 favor
   });


  it('verifica se o total de propostas esta correto', async () => {
    //const dInstance = await Democracy.deployed();
    const total = await d1.getProposalsLength.call();

    assert.equal(total.valueOf(), TOTAL_PROPOSALS, TOTAL_PROPOSALS + " nao eh o total de propostas");
  });

  
});

const SimpleAgenda = artifacts.require("SimpleAgenda");

contract('SimpleAgenda', (accounts) => {

  //instancia atual do contrato
  var contract_instance;

  beforeEach(async () => {
    contract_instance = await SimpleAgenda.new();
  });

  it('possible_to_add_a_new_contact', async () => {

  });

  it('possible_to_remove_a_contact', async () => {
      
  });

  it('possible_to_count_the_contacts', async () => {
      
  });

  it('possible_to_get_a_number_by_his_index', async () => {
      
  });

  it('possible_to_get_a_contact_by_his_number', async () => {
      
  });

});

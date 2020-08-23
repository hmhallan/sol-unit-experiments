const ConvertLib = artifacts.require("ConvertLib");
const MetaCoin = artifacts.require("MetaCoin");
const Democracy = artifacts.require("Democracy");
const SimpleAgenda = artifacts.require("SimpleAgenda");

module.exports = function(deployer) {
  deployer.deploy(ConvertLib);
  deployer.link(ConvertLib, MetaCoin);
  deployer.deploy(MetaCoin);
  deployer.deploy(Democracy);
  deployer.deploy(SimpleAgenda);
};

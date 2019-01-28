package experiments.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Ballot extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051610835380380610835833981016040908152815160008054600160a060020a0319163317808255600160a060020a031681526001602081905292812092909255909101905b81518110156100bc5760026040805190810160405280848481518110151561007d57fe5b60209081029091018101518252600091810182905283546001818101865594835291819020835160029093020191825591909101519082015501610059565b5050610768806100cd6000396000f30060806040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630121b93f8114610092578063013cf08b146100ac5780632e4176cf146100dd5780635c19a95c1461010e578063609ff1bd1461012f5780639e7b8d6114610156578063a3ec138d14610177578063e2ba53f0146101c6575b600080fd5b34801561009e57600080fd5b506100aa6004356101db565b005b3480156100b857600080fd5b506100c46004356102e6565b6040805192835260208301919091528051918290030190f35b3480156100e957600080fd5b506100f2610312565b60408051600160a060020a039092168252519081900360200190f35b34801561011a57600080fd5b506100aa600160a060020a0360043516610321565b34801561013b57600080fd5b50610144610534565b60408051918252519081900360200190f35b34801561016257600080fd5b506100aa600160a060020a036004351661059e565b34801561018357600080fd5b50610198600160a060020a03600435166106db565b604080519485529215156020850152600160a060020a03909116838301526060830152519081900360800190f35b3480156101d257600080fd5b5061014461070f565b33600090815260016020526040902080541515610242576040805160e560020a62461bcd02815260206004820152601460248201527f486173206e6f20726967687420746f20766f7465000000000000000000000000604482015290519081900360640190fd5b600181015460ff161561029f576040805160e560020a62461bcd02815260206004820152600e60248201527f416c726561647920766f7465642e000000000000000000000000000000000000604482015290519081900360640190fd5b6001818101805460ff19169091179055600280820183905581548154909190849081106102c857fe5b60009182526020909120600160029092020101805490910190555050565b60028054829081106102f457fe5b60009182526020909120600290910201805460019091015490915082565b600054600160a060020a031681565b33600090815260016020819052604082209081015490919060ff1615610391576040805160e560020a62461bcd02815260206004820152601260248201527f596f7520616c726561647920766f7465642e0000000000000000000000000000604482015290519081900360640190fd5b600160a060020a0383163314156103f2576040805160e560020a62461bcd02815260206004820152601e60248201527f53656c662d64656c65676174696f6e20697320646973616c6c6f7765642e0000604482015290519081900360640190fd5b600160a060020a03838116600090815260016020819052604090912001546101009004161561049f57600160a060020a03928316600090815260016020819052604090912001546101009004909216913383141561049a576040805160e560020a62461bcd02815260206004820152601960248201527f466f756e64206c6f6f7020696e2064656c65676174696f6e2e00000000000000604482015290519081900360640190fd5b6103f2565b506001818101805460ff1916821774ffffffffffffffffffffffffffffffffffffffff001916610100600160a060020a0386169081029190911790915560009081526020829052604090209081015460ff16156105275781546002828101548154811061050857fe5b600091825260209091206001600290920201018054909101905561052f565b815481540181555b505050565b600080805b600254811015610599578160028281548110151561055357fe5b906000526020600020906002020160010154111561059157600280548290811061057957fe5b90600052602060002090600202016001015491508092505b600101610539565b505090565b600054600160a060020a03163314610626576040805160e560020a62461bcd02815260206004820152602860248201527f4f6e6c79206368616972706572736f6e2063616e20676976652072696768742060448201527f746f20766f74652e000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b600160a060020a0381166000908152600160208190526040909120015460ff161561069b576040805160e560020a62461bcd02815260206004820152601860248201527f54686520766f74657220616c726561647920766f7465642e0000000000000000604482015290519081900360640190fd5b600160a060020a038116600090815260016020526040902054156106be57600080fd5b600160a060020a0316600090815260016020819052604090912055565b600160208190526000918252604090912080549181015460029091015460ff8216916101009004600160a060020a03169084565b6000600261071b610534565b8154811061072557fe5b9060005260206000209060020201600001549050905600a165627a7a72305820e19c5c2146ee1e8563850bbc740f3250d34306191949cc5a655cc4313ecad7f70029";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_PROPOSALS = "proposals";

    public static final String FUNC_CHAIRPERSON = "chairperson";

    public static final String FUNC_DELEGATE = "delegate";

    public static final String FUNC_WINNINGPROPOSAL = "winningProposal";

    public static final String FUNC_GIVERIGHTTOVOTE = "giveRightToVote";

    public static final String FUNC_VOTERS = "voters";

    public static final String FUNC_WINNERNAME = "winnerName";

    protected Ballot(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ballot(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger proposal) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<byte[], BigInteger>> proposals(BigInteger param0) {
        final Function function = new Function(FUNC_PROPOSALS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<byte[], BigInteger>>(
                new Callable<Tuple2<byte[], BigInteger>>() {
                    @Override
                    public Tuple2<byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<byte[], BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> chairperson() {
        final Function function = new Function(FUNC_CHAIRPERSON, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> delegate(String to) {
        final Function function = new Function(
                FUNC_DELEGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> winningProposal() {
        final Function function = new Function(FUNC_WINNINGPROPOSAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> giveRightToVote(String voter) {
        final Function function = new Function(
                FUNC_GIVERIGHTTOVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(voter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<BigInteger, Boolean, String, BigInteger>> voters(String param0) {
        final Function function = new Function(FUNC_VOTERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<BigInteger, Boolean, String, BigInteger>>(
                new Callable<Tuple4<BigInteger, Boolean, String, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, Boolean, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, Boolean, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<byte[]> winnerName() {
        final Function function = new Function(FUNC_WINNERNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public static RemoteCall<Ballot> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(proposalNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Ballot> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> proposalNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(proposalNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Ballot.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Ballot load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Ballot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ballot(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
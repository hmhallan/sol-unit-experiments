pragma solidity >=0.4.25 <0.7.0;

contract SimpleAgenda {

    event AddNewContact(string name, bytes32 number, string email, uint index);
    event DeleteContact(bytes32 number, uint index);
    
    struct Contact {
        string name;
        bytes32 number;
        string email;
        uint index;
    }

    bytes32[] private contactIndex;
    
    mapping(bytes32 => Contact) private mapping_number;
    
    function newContact (string memory _name, bytes32 _number, string memory  _email) public returns (bool) {
        if (!contactExist(_number)) {
            Contact memory contato = Contact(_name, _number, _email, contactIndex.length);
        
            mapping_number[_number] = contato;
            contactIndex.push(_number);
        
            emit AddNewContact(_name, _number, _email, contactIndex.length);
        } else {
            revert();
        }
        
    }
    
    function getContact (bytes32 _number) public view returns (string memory , string memory ) {
        if (contactExist(_number)) {
            Contact memory contato = mapping_number[_number];
        
            return (contato.name, contato.email);
        } else {
            revert();
        }
    } 
    
    function deleteContact (bytes32 _number) public {
        if (contactExist(_number)) {
            uint contactToDelete = mapping_number[_number].index;
            
            emit DeleteContact(_number, contactToDelete);
            
            bytes32 contactToMove = contactIndex[contactIndex.length - 1];
            
            contactIndex[contactToDelete] = contactToMove;
            
            mapping_number[contactToMove].index = contactToDelete;
            
            contactIndex.length --;
        } else {
            revert();
        }
    }
    
    function contactExist (bytes32 _number) public view returns (bool isContact) {
        int nex = -1;
        if (int(mapping_number[_number].index) != nex) 
            return true;

        //if (keccak256(contactIndex[mapping_number[_number].index]) == keccak256(_number)) {
            return false;
        //} else {
        //    return false;
        //}
    }
    
    function countContacts() public view returns (uint) {
        return contactIndex.length;
    }
    
    function getNumberAtIndex(uint index) public view returns (bytes32) {
        return contactIndex[index];
    }
}
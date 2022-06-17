package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.StorePackage.Store;
import com.tsi.abbas.gure.program.StorePackage.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
;import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {


    //Store repository instantiated
    @Autowired
    private StoreRepository storeRepository;




    /**This is for getting all the contents of the stores from the store table in the sakila database
     * More specifically in terms of CRUD functions this is the 'Read'*/
    @GetMapping("/All_Stores")
    public @ResponseBody
    Iterable<Store> getAllStores(){
        return storeRepository.findAll();
    }

    /**
     *
     * @param storeId is the ID of the store that is used as parameter for searching for store's existence in table
     * @return true if the store exists else return false, a simple boolean class for existence of store's ID
     */
    @GetMapping("/Stores/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int storeId){
        if (storeRepository.existsById(storeId)){
            return true ;
        }else return false ;
    }


    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_ID")
    public @ResponseBody
    String deleteById(@RequestParam int storeId){

        storeRepository.deleteById(storeId);
        return "Successfully deleted";
    }


    /**Out of the CRUD functions this is the 'Update' Method */
    @PutMapping("/Replace_By_ID")
    public @ResponseBody String updateStore(@RequestParam int storeId ,@RequestParam int storeAddressID,@RequestParam int staffSize)
    {
        //A string we will use later as a message that values were successfully updated, you'll see it below
        String valueWasUpdated = "Values were updated";


        //using crud respository method that we got from extended class, check if id of store exists in the database
        if(storeRepository.existsById(storeId) && storeRepository.findById(storeAddressID).isPresent()){
            // if it does find the specific ID in the database using the ID of the store and put it in a temp store value
            Store store = new Store();

            //Find Store ID
            store = storeRepository.findById(storeId).get();

            //Once finding store user inputs relevant values to storeAddressID and  staffSize variables
            store.setStoreAddressID(storeAddressID);
            store.setStaffSize(staffSize);

            //Repository save/updates the store detail changes.
            storeRepository.save(store);

        } else {
            //If we do not find the store in the repository or if they do not exist
            valueWasUpdated = "ID not found";
        }
        //Basically by this point we updated the value if correctly found
        return valueWasUpdated;


    }

    /**Out of the CRUD functions this is the 'Create' */
    @PostMapping("/Create_By_ID")
    public  @ResponseBody Store newStore(  @RequestParam int storeID,@RequestParam int storeAddressID, @RequestParam int staffSize)
    {
        //Store instance that we will use for our new store
        Store newStore = new Store();

        /** I didnt add id variable to be created/updated because it is autoincrementally added by the database,
         * if I do add id it would not create/update with the save method */


        //Setting Stores values
        //Then returning the value to user along with the ID they were assigned by the table
        newStore.setStoreAddressID(storeAddressID);
        newStore.setStaffSize(staffSize);
        return storeRepository.save(newStore);
    }









}

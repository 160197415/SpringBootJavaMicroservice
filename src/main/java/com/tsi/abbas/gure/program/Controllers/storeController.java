package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.StorePackage.Store;
import com.tsi.abbas.gure.program.StorePackage.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
;import org.springframework.web.bind.annotation.*;

@RestController
public class storeController {


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
     * @param store_id is the ID of the store that is used as parameter for searching for store's existence in table
     * @return true if the store exists else return false, a simple boolean class for existence of store's ID
     */
    @GetMapping("/Stores/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int store_id){
        if (storeRepository.existsById(store_id)){
            return true ;
        }else return false ;
    }


    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_Store_ID")
    public @ResponseBody
    String deleteById(@RequestParam int store_id){

        storeRepository.deleteById(store_id);
        return "Successfully deleted";
    }


    /**Out of the CRUD functions this is the 'Update' Method */
    @PutMapping("/Replace_By_Store_ID")
    public @ResponseBody String updateStore(@RequestParam int store_id ,@RequestParam int address_id,@RequestParam int manager_staff_id)
    {
        //A string we will use later as a message that values were successfully updated, you'll see it below
        String valueWasUpdated = "Values were updated";


        //using crud respository method that we got from extended class, check if id of store exists in the database
        if(storeRepository.existsById(store_id) && storeRepository.findById(address_id).isPresent()){
            // if it does find the specific ID in the database using the ID of the store and put it in a temp store value
            Store store = new Store();

            //Find Store ID
            store = storeRepository.findById(store_id).get();

            //Once finding store user inputs relevant values to address_id and  manager_staff_id variables
            store.setAddress_id(address_id);
            store.setManager_staff_id(manager_staff_id);

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
    @PostMapping("/Create_By_Store_ID")
        public  @ResponseBody Store newStore(  @RequestParam int store_id,@RequestParam int address_id, @RequestParam int manager_staff_id)
    {
        //Store instance that we will use for our new store
        Store newStore = new Store();

        /** I didn't add id variable to be created/updated because it is auto incrementally added by the database,
         * if I do add id it would not create/update with the save method */


        //Setting Stores values
        //Then returning the value to user along with the ID they were assigned by the table
        newStore.setStore_id(store_id);
        newStore.setAddress_id(address_id);
        newStore.setManager_staff_id(manager_staff_id);
        return storeRepository.save(newStore);
    }









}

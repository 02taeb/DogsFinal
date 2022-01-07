/**
 * Owner class according to AssignmentEightPointOne on iLearn PROG1.
 * 
 * @author Lucas Ilstedt, luil7872
 */
public class Owner {
    // #region Instance Variables
    private Dog[] ownedDogs = new Dog[0];
    private String name;
    // #endregion

    /**
     * Constructor. Takes String ownerName and sets this.name = ownerName.
     * 
     * @param ownerName
     */
    public Owner(String ownerName) {
        name = ownerName;
    }

    /**
     * Getter for this.name
     * 
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if this Owner owns thisDog.
     * 
     * @param thisDog Dog to check.
     * @return boolean true if thisDog is owned by this Owner, else false.
     */
    // @UnderTest(id = "U8.5")
    public boolean hasDog(Dog thisDog) {
        for (int i = 0; i < ownedDogs.length; i++) {
            if (ownedDogs[i].getName().equalsIgnoreCase(thisDog.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * &#064;Override toString.
     * 
     * @return String name.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Prints all owned Dogs with the Dog.toString() method.
     */
    public void listOwnedDogs() {
        for (Dog dog : ownedDogs) {
            System.out.println("*" + dog.toString());
        }
    }

    /**
     * Adds dog to this Owner.
     * 
     * @param dog Dog to add.
     * @return boolean, true if dog added, false if dog already owned.
     */
    // @UnderTest(id = "U8.3")
    public boolean addDogToOwner(Dog dog) {
        // Check hasDog() unnecessary?
        if (!hasDog(dog) && !dog.isOwned()) {
            expandArray();
            ownedDogs[ownedDogs.length - 1] = dog;
            dog.setOwner(this);
            return true;
        } else {
            // System.out.println("Error: This dog is already owned by this or another
            // owner.");
            return false;
        }
    }

    /**
     * Removes a dog from this owner.
     * 
     * @param dog Dog to remove.
     */
    // @UnderTest(id = "U8.6")
    public void removeDogFromOwner(Dog dog) {
        for (int i = 0; i < ownedDogs.length; i++) {
            if (ownedDogs[i] == dog) {
                decreaseArray(i);
                dog.removeOwner();
                return;
            }
        }
    }

    /**
     * Removes a space in the ownedDogs[].
     * 
     * @param removeDogIndex Space that will be removed (actually value that will be
     *                       "forgotten").
     */
    private void decreaseArray(int removeDogIndex) {
        for (int i = removeDogIndex; i < ownedDogs.length - 1; i++) {
            ownedDogs[i] = ownedDogs[i + 1];
        }

        Dog[] middleStepArr = new Dog[ownedDogs.length - 1];
        for (int i = 0; i < middleStepArr.length; i++) {
            middleStepArr[i] = ownedDogs[i];
        }

        ownedDogs = new Dog[ownedDogs.length - 1];

        for (int i = 0; i < middleStepArr.length; i++) {
            ownedDogs[i] = middleStepArr[i];
        }
    }

    /**
     * Will "expand" local Dog[] ownedDogs if new dog is to be added.
     */
    private void expandArray() {
        Dog[] middleStepArr = new Dog[ownedDogs.length];

        for (int i = 0; i < ownedDogs.length; i++) {
            middleStepArr[i] = ownedDogs[i];
        }

        ownedDogs = new Dog[ownedDogs.length + 1];

        for (int i = 0; i < middleStepArr.length; i++) {
            ownedDogs[i] = middleStepArr[i];
        }
    }
}

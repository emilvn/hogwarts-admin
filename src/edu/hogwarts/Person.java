package src.edu.hogwarts;

public class Person{
    private String firstName;
    private String lastName;
    private String middleName;

    public Person(){

    }

    public Person(String fullName){
        setFullName(fullName);
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getMiddleName(){
        return middleName;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFullName(){
        if(hasMiddleName()){
            return getFirstName() + " " + getMiddleName() + " " + getLastName();
        }
        return getFirstName() + " " + getLastName();
    }
    public void setFullName(String fullName){
        int firstSpaceIndex = fullName.indexOf(" ");
        int lastSpaceIndex = fullName.lastIndexOf(" ");
        if(firstSpaceIndex == -1){
            setFirstName(fullName);
            return;
        }
        setFirstName(fullName.substring(0, firstSpaceIndex));
        if(firstSpaceIndex != lastSpaceIndex){
            setMiddleName(fullName.substring(firstSpaceIndex+1, lastSpaceIndex));
        }else{
            this.middleName = null;
        }
        setLastName(fullName.substring(lastSpaceIndex+1));
    }


    public boolean hasMiddleName(){
        return middleName != null;
    }

    public String capitalize(String str){
        char firstChar = str.charAt(0);
        if(!str.contains(" ") && str.contains("-")){
            return Character.toUpperCase(firstChar) + str.substring(1).toLowerCase();
        }
        else if(str.contains("-") && (str.indexOf("-") < str.indexOf(" ") || !str.contains(" "))){
            String capitalized = Character.toUpperCase(firstChar) + str.substring(1, str.indexOf("-")).toLowerCase();
            return capitalized + "-" + capitalize(str.substring(str.indexOf("-")+1));
        }
        String capitalized = Character.toUpperCase(firstChar) + str.substring(1, str.indexOf(" ")).toLowerCase();
        return capitalized + " " + capitalize(str.substring(str.indexOf(" ")+1));
    }


    @Override
    public String toString(){
        return this.getClass() + "{\nfirstName:"+firstName+",\nmiddleName:"+middleName+",\nlastName:"+lastName+"\n}";
    }
}
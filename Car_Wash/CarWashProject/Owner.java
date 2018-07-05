public class Owner{
    private String ownerName;
    private String ownerCode;

    public Owner(String ownerName, String ownerCode){
        this.ownerName = ownerName;
        this.ownerCode = ownerCode;
    }

    public String getOwnername(){
        return this.ownerName;
    }
    public String getOwnerCode(){
        return this.ownerCode;
    }
}
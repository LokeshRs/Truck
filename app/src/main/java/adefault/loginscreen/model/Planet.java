package adefault.loginscreen.model;

public class Planet {
    public String name;
    public String rotationPeriod;
    public String climate;
    public String population;
    public String getName()
    {
        return name;
    }
    public void setName(String name){

        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    @Override
    public String toString() {
        return /*"Planet{" +
                "name='" + */name  ;
               // ", rotationPeriod='" + rotationPeriod + '\'' +
                //", climate='" + climate + '\'' +
                //", population='" + population + '\'' +
                //'}' ;
    }
}

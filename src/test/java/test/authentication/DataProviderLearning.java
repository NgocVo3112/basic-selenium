package test.authentication;

import Utils.data.DataObjectBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLearning {

    @Test(dataProvider = "wrongCredsData")
    public void loginWithIncorrectCreds(CredsData credsData){
        System.out.println(credsData.getUsername());
        System.out.println(credsData.getPassword() );
        System.out.println("--------------------\n");
    }
    @DataProvider
    public CredsData[] wrongCredsData(){
        String jsonDataFileLocation = "/src/test/resources/test-data/authentication/LoginCreds.json";
        return DataObjectBuilder.buildCredObject(jsonDataFileLocation);
    }

    @DataProvider
    public Object[][] wrongCredsDatabk(){
        return new Object[][]{
                {"Test1","wrongPassword1"},
                {"Test2","wrongPassword2"}
        };
    }

}

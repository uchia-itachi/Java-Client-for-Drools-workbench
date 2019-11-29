import com.myspace.TaxPayer;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.internal.command.CommandFactory;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MAIN {

    public static  final String URL = "http://localhost:8080/kie-server/services/rest/server";
    public static  final String USER = "kieserver";
    public static  final String PASSWORD = "kieserver1!";
    private static  final MarshallingFormat FORMAT = MarshallingFormat.JSON;

    private static String containerID = "Taxes";
    private  static  String className = "com.myspace.TaxPayer";
    public static TaxPayer  person = new TaxPayer();

    public static void create(){
        person.setHra(1000);
        person.setSalary(4000000);
        person.setSa(1000);
        person.setAge(23);
        person.setTa(2000);
    }
    public static void main(String[] args) throws InterruptedException {
        create();
        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(URL,USER,PASSWORD);
        config.setMarshallingFormat(FORMAT);
        RuleServicesClient client = KieServicesFactory.newKieServicesClient(config).getServicesClient(RuleServicesClient.class);
        List<Command<?>> cmds = new ArrayList<Command<?>>();
        KieCommands commands = KieServices.Factory.get().getCommands();
        cmds.add(commands.newInsert(person,className));
        cmds.add(commands.newFireAllRules());
        BatchExecutionCommand myCommands = CommandFactory.newBatchExecution(cmds);
        ServiceResponse<ExecutionResults> respone ;

        Scanner scan = new Scanner(System.in);
        String run = "yes";
        while(true){
            respone = client.executeCommandsWithResults(containerID, myCommands);
            if(respone.getType() == ServiceResponse.ResponseType.SUCCESS){
                System.out.println("sucessfully connected");
                TaxPayer updatedPerson = (TaxPayer) respone.getResult().getValue(className);
                System.out.println(updatedPerson);
            }
            else{
                System.out.println("error in executing rules");
                System.out.println(respone.getMsg());
            }
            TimeUnit.SECONDS.sleep(2);
        }


    }
}

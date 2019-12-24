import com.mpowered.commons.ruleengine.pojo.AwardPointGrant;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieSession;
import org.kie.internal.command.CommandFactory;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MAIN {

    public static  final String URL = "http://18.189.196.88:8080/kie-server/services/rest/server";
    public static  final String USER = "kieserver";
    public static  final String PASSWORD = "kieserver1!";
    private static  final MarshallingFormat FORMAT = MarshallingFormat.JSON;

    private static String containerID = "businessevent";
    private  static  String className = "com.mpowered.commons.ruleengine.pojo.AwardPointGrant";
    public  static AwardPointGrant awardPointGrant = new AwardPointGrant();


    public static void main(String[] args) throws InterruptedException {

        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(URL,USER,PASSWORD);
        config.setMarshallingFormat(FORMAT);
        RuleServicesClient client = KieServicesFactory.newKieServicesClient(config).getServicesClient(RuleServicesClient.class);
        List<Command<?>> cmds = new ArrayList<Command<?>>();
        KieCommands commands = KieServices.Factory.get().getCommands();
        while(true){
            cmds.add(commands.newInsert(awardPointGrant,className));
            cmds.add(commands.newFireAllRules());
            BatchExecutionCommand myCommands = CommandFactory.newBatchExecution(cmds);

            ServiceResponse<ExecutionResults> respone = client.executeCommandsWithResults(containerID, myCommands);
            if(respone.getType() == ServiceResponse.ResponseType.SUCCESS){
                System.out.println("sucessfully connected");
                AwardPointGrant updatedPerson = (AwardPointGrant) respone.getResult().getValue(className);

                System.out.println(updatedPerson.getAwardPointGrantResponse().getAwardPoints());
            }
            else{
                System.out.println("error in executing rules");
                System.out.println(respone.getMsg());
            }
            TimeUnit.SECONDS.sleep(2);
        }


    }
}

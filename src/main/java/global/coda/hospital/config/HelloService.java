package global.coda.hospital.config;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.patientdao.PatientSqlDAO;
@Path("/service")
public class HelloService {
    @GET
    @Path("/print/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public PatientRecord hello(@PathParam("name") String name) {
        PatientSqlDAO patient=new PatientSqlDAO();
        PatientRecord record=new PatientRecord();
        record=patient.getPatientRecord(name);
        return record;
    }
}
package parsing;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fmu.Mapping;
import fmu.Model;
import org.semanticweb.owlapi.model.OWLAxiom;
import utils.FMU2OWLConverter;
import utils.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JsonParser {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Model model = objectMapper.readValue(Files.readAllBytes(Paths.get("src/main/resources/json/CraneController.json")), Model.class);
//        Model model = objectMapper.readValue(Files.readAllBytes(Paths.get("src/main/resources/json/KnuckleBoomCrane.json")), Model.class);
        Mapping mapping = objectMapper.readValue(Files.readAllBytes(Paths.get("src/main/resources/json/mapping.json")), Mapping.class);

        System.out.println(mapping);

        try {
            FMU2OWLConverter converter = new FMU2OWLConverter("http://www.dnvgl.com/irm/osp/rdl/", "rdl:", "http://www.dnvgl.com/irm/fmu/");
//        mapping.getPlugSocketConnections().get(0).accept(converter, "psc");
            mapping.accept(converter);

            List<String> strs = new ArrayList<>();
            for (OWLAxiom a : converter.getAxioms()) {
                strs.add(a.toString());
            }
            strs.sort(String::compareTo);
            System.out.println(StringUtils.toStringAsOneItemPerLine(strs));
        } catch (Exception e) {
            System.out.println("Conversion failed: " + e.getMessage());
        }
    }
}

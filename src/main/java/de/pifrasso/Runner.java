package de.pifrasso;

import de.pifrasso.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.TreeSet;

@RestController
@SpringBootApplication
//@EnableJpaRepositories("de.skyeye.rail.fahrzeug.model.*")
//@ComponentScan(basePackages = { "de.skyeye.rail.stammdaten.model.HandbremseArt","de.pifrasso.model"})
//@EnableJpaRepositories ( basePackages = {"de.skyeye.rail.stammdaten.model","de.pifrasso.model"})

//@EntityScan(basePackageClasses ={de.skyeye.rail.stammdaten.model.HandbremseArt.class, Workorder.class})
@EnableJpaRepositories
//@EnableSwagger2

public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);


    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "Nothing here. Go to <a href='/sample'>/sample</a>";
    }

    static public void main(String[] args) throws Exception {
        SpringApplication.run(Runner.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository,
                           WorkorderRepository workorderRepository,
                           WaggonRepository waggonRepository,
                           DefectCodeRepository defectCodeRepository,
                           DefectRepository defectRepository,
                           CustomerRepository customerRepository,
                           WaggonSequenceRepository waggonSequenceRepository,
                           ShunterOrderRepository shunterOrderRepository) {
        return (args) -> {
            User franz = userRepository.save(new User("Andreas", "Franz", "fra", "fra"));
            User bajohra = userRepository.save(new User("Andreas", "Bajohra", "baj", "baj"));
            User petrou = userRepository.save(new User("Andreas", "Petrou", "pet", "pet"));
            User frass = userRepository.save(new User("Andreas", "Frass", "afs", "afs"));
            User schulz = userRepository.save(new User("Stefan", "Schulz", "ssz", "ssz"));

            Waggon w1 = waggonRepository.save(new Waggon("8892922221"));
            Waggon w2 = waggonRepository.save(new Waggon("2423525324"));
            Waggon w3 = waggonRepository.save(new Waggon("3534535346"));
            Waggon w4 = waggonRepository.save(new Waggon("1414141412"));
            Waggon w5 = waggonRepository.save(new Waggon("6577474745"));

            Workorder wo1 = workorderRepository.save(new Workorder("WTU1", frass, new Date(), new Date(), WorkorderStatus.New));
            Workorder wo2 = workorderRepository.save(new Workorder("WTU2", frass, new Date(), new Date(), WorkorderStatus.New));
            Workorder wo3 = workorderRepository.save(new Workorder("WTU3", frass, new Date(), new Date(), WorkorderStatus.New));
            Workorder wo4 = workorderRepository.save(new Workorder("WTU4", frass, new Date(), new Date(), WorkorderStatus.New));
            Workorder wo5 = workorderRepository.save(new Workorder("WTU5", franz, new Date(), new Date(), WorkorderStatus.New));



            WaggonSequence ws1 = waggonSequenceRepository.save(new WaggonSequence(w1,1));
            WaggonSequence ws2 = waggonSequenceRepository.save(new WaggonSequence(w2,2));

            WaggonSequence ws3 = waggonSequenceRepository.save(new WaggonSequence(w3,3));
            WaggonSequence ws4 = waggonSequenceRepository.save(new WaggonSequence(w4,2));
            WaggonSequence ws5 = waggonSequenceRepository.save(new WaggonSequence(w5,1));

            ShunterOrder so1 = shunterOrderRepository.save(new ShunterOrder("R1", frass, new Date(), new Date(), WorkorderStatus.New, new TreeSet(){{add(ws1);add(ws2);}}));
            ShunterOrder so2 = shunterOrderRepository.save(new ShunterOrder("R2", frass, new Date(), new Date(), WorkorderStatus.New, new TreeSet(){{add(ws3);add(ws4);add(ws5);}}));


            DefectCode dc1 = defectCodeRepository.save(new DefectCode("1.0.0", "First", "part"));
            DefectCode dc2 = defectCodeRepository.save(new DefectCode("1.0.1", "Second", "part"));
            DefectCode dc3 = defectCodeRepository.save(new DefectCode("1.0.2", "Third", "part"));
            DefectCode dc4 = defectCodeRepository.save(new DefectCode("1.1.0", "Fourth", "part"));
            DefectCode dc5 = defectCodeRepository.save(new DefectCode("2.0.0", "Eins", "part"));
            DefectCode dc6 = defectCodeRepository.save(new DefectCode("2.1.0", "Zwei", "part"));
            DefectCode dc7 = defectCodeRepository.save(new DefectCode("2.1.1", "Drei", "part"));

            Defect d1 = defectRepository.save(new Defect(frass, dc1, "Erster defect", w1));
            Defect d2 = defectRepository.save(new Defect(frass, dc2, "Zweiter defect", w2));

            // save a couple of customers
            customerRepository.save(new Customer("Peter", "Bauer"));
            customerRepository.save(new Customer("Markus", "Petersen"));
            customerRepository.save(new Customer("Kim", "Schmitz"));
            customerRepository.save(new Customer("David", "Davidsen"));
            customerRepository.save(new Customer("Stefan", "Stefansen"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = customerRepository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : customerRepository
                    .findByLastNameStartsWithIgnoreCase("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");

            //Wagen wagen1 = new Wagen();
            //wagen1.setBezeichnung("Wagen1");
            //Wagen derWagen1 = wagenRepo.save(wagen1);

            //Wagen wagen2 = new Wagen();
            //wagen2.setBezeichnung("Wagen2");
            //Wagen derWagen2 = wagenRepo.save(wagen2);

        };
    }

    /*
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.pifrasso"))
                .paths(PathSelectors.any())
                .build();
    }
*/
}

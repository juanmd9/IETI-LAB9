package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
   
        System.out.println();


        todoRepository.deleteAll();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        todoRepository.save(new Todo(1l, "Laboratorio ieti y este es una prueba para tener mas de 30 caracteres.", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Juan", "pending"));
        todoRepository.save(new Todo(2l, "Laboratorio arep", 2l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Juan", "pending"));
        todoRepository.save(new Todo(3l, "Tarea de investigación", 5l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Juan", "pending"));
        todoRepository.save(new Todo(4l, "Cita médica", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Manuel", "pending"));
        todoRepository.save(new Todo(5l, "Algo", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Manuel", "pending"));
        todoRepository.save(new Todo(6l, "Cita", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Daniel", "pending"));
        todoRepository.save(new Todo(7l, "Tarea", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Daniel", "pending"));
        todoRepository.save(new Todo(8l, "Salir", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Felipe", "pending"));
        todoRepository.save(new Todo(8l, "Ir a entrenar", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Felipe", "pending"));
        todoRepository.save(new Todo(9l, "Hacer cardio", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Luis", "pending"));
        todoRepository.save(new Todo(10l, "Hacer tareas", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Luis", "pending"));
        todoRepository.save(new Todo(11l, "Estudiar", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Ana", "pending"));
        todoRepository.save(new Todo(12l, "Presentar examen", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Ana", "pending"));
        todoRepository.save(new Todo(13l, "Descansar", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Sofia", "pending"));
        todoRepository.save(new Todo(14l, "Salir al parque", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Sofia", "pending"));
        todoRepository.save(new Todo(15l, "Hacer mercado", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Daniel", "pending"));
        todoRepository.save(new Todo(16l, "Cita Ortodoncia", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Daniel", "pending"));
        todoRepository.save(new Todo(17l, "Cita con Juan", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Valentina", "pending"));
        todoRepository.save(new Todo(18l, "Entrenar boxing", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Valentina", "pending"));
        todoRepository.save(new Todo(19l, "Hacer crossfit", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Valentina", "pending"));
        todoRepository.save(new Todo(20l, "Verse con amigos", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Valeria", "pending"));
        todoRepository.save(new Todo(21l, "Salir con amigas", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Valeria", "pending"));
        todoRepository.save(new Todo(22l, "Salir a comer", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Maria", "pending"));
        todoRepository.save(new Todo(23l, "Ir a clase", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Maria", "pending"));
        todoRepository.save(new Todo(24l, "Cita con Valentina", 10l, format.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L)), "Juan", "pending"));
        todoRepository.save(new Todo(25l, "Ir a bailar", 10l, format.format(new Date()), "Manuel", "pending"));

        System.out.println("Paginated search of todos by criteria:");
        System.out.println("-------------------------------");

        todoRepository.findByResponsibleContaining("Juan", PageRequest.of(0, 5)).stream()
                .forEach(System.out::println);

        System.out.println();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is("Alice"));

        Customer customer = mongoOperation.findOne(query, Customer.class);

        System.out.println("Customer found by Query:");
        System.out.println("-------------------------------");

        System.out.println(customer);

        System.out.println();

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("dueDate").lt(format.format(new Date())));
        List<Todo> todoList = mongoOperation.find(query1, Todo.class);

        System.out.println("DueDate expired, found by Query:");
        System.out.println("-------------------------------");

        todoList.forEach(todo -> System.out.println(todo));

        System.out.println();

        Query query2 = new Query();
        String givenUser = "Juan";
        query2.addCriteria(Criteria.where("responsible").regex(givenUser));
        query2.addCriteria(Criteria.where("priority").gte(5));
        List<Todo> todoListByUser = mongoOperation.find(query2, Todo.class);

        System.out.println("Given user and priority greater equal to 5, found by Query:");
        System.out.println("-------------------------------");

        todoListByUser.forEach(todo -> System.out.println(todo));

        System.out.println();

        /*Query query3 = new Query();
        query3.addCriteria(Criteria.where());
        List<Todo> todoListUserTwoTodo = mongoOperation.find(query3, Todo.class);

        System.out.println("Todos that contains a description with a length greater than 30 characters, found by Query:");
        System.out.println("-------------------------------");

        todoListUserTwoTodo.forEach(todo -> System.out.println(todo));

        System.out.println();*/

        Query query4 = new Query();
        query4.addCriteria(Criteria.where("description").regex("[a-z,A-Z,0-9,' ']{30,}"));
        List<Todo> todoListByDescription = mongoOperation.find(query4, Todo.class);

        System.out.println("Todos that contains a description with a length greater than 30 characters, found by Query:");
        System.out.println("-------------------------------");

        todoListByDescription.forEach(todo -> System.out.println(todo));

        System.out.println();
    }

}
package templates;

public interface CustomerRepository extends  CrudRepository<Customer, Integer>{
 Customer findById (int id);
}
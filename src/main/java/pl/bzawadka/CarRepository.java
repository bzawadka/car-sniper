package pl.bzawadka;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pl.bzawadka.model.Car;
import pl.bzawadka.model.Make;

import java.util.List;

public interface CarRepository extends ElasticsearchRepository<Car, String> {

    public List<Car> findByMake(Make make);

}

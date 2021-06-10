package disproject.perun.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import disproject.perun.models.Item;

@FeignClient(name="svarog")
public interface SvarogProxy {

	@GetMapping("/items/perun")
	public List<Item> retrieveItems(@RequestBody List<Item> itemsTemp);
	
}

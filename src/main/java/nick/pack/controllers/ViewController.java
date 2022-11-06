package nick.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nick.pack.models.Bank;
import nick.pack.models.BankAccount;
import nick.pack.models.Client;
import nick.pack.models.Worker;
import nick.pack.service.BankAccountService;
import nick.pack.service.BankService;
import nick.pack.service.ClientService;
import nick.pack.service.WorkerService;

@Controller
public class ViewController {
	@Autowired
	private BankService bankService;
	@Autowired
	private BankAccountService bankAccountService;
	@Autowired
	private WorkerService workerService;
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/hello")
	public String index(Model model) {
		Worker worker = new Worker("Ivan2", "Ivanov2", "bankir2", "895323412542");
		BankAccount bankAccount = new BankAccount("rus", 31432.32, 234124423.64);
		Client client = new Client("Karasev2", "Viktor2", "8934582322", "2vik@mail.ru", bankAccount);
		Bank bank = new Bank("Tinkoff2", worker, client);
		workerService.insert(worker);
		bankAccountService.insert(bankAccount);
		clientService.insert(client);
		bankService.insert(bank);
		Client client2 = new Client("Test2", "Test2", "test2", "2test@", bankAccount);
		clientService.insert(client2);
		System.out.println(clientService.selectAll());
		clientService.delete(client2);
		System.out.println(clientService.selectAll());
		client.setFirstName("Emelyanov");
		clientService.update(client);
		System.out.println(clientService.selectAll());
		model.addAttribute("banks", bankService.selectAll());
		//
		return "index";
	}
}

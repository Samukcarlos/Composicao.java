package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level; 
	private Double baseSalary;
	
	private Departament departament;      // Associando com a classe departament, instanciado na classe Program linha 26.
	
	private List<HourContract> contracts = new ArrayList<>(); // criando uma lista de contratos, 
										 //associando com contract. A lista deve ser instanciada, como foi.
										// A Lista não deve ser inclusa no construtor com argumentos.
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double beseSalary) {
		this.baseSalary = beseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	//public void setContracts(List<HourContract> contracts) { Não podemos deixar que a lista possa ser trocada
		//this.contracts = contracts;} neste método ele recebe outra lista e a adiciona oa contract.
	

	public void addContract(HourContract contract) { // pega a lista de contrato e adiciona o contrato que veio como argumento.
		contracts.add(contract);
	}
		
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month ) { //salario + os contratos no mês selecionado
		double sum = baseSalary;                 
		Calendar cal = Calendar.getInstance(); // instanciando calendário                                       
		for (HourContract c : contracts){    
			// para cada contrato c na lista de contract vou testar se o contrato c é do mês selecionado, caso seja entra na conta.
			cal.setTime(c.getDate());       // para cada contrato c eu pego a data do mesmo.
			int c_year = cal.get(Calendar.YEAR);//pegando o nao                  
			int c_month = 1 + cal.get(Calendar.MONTH);
			// pegando o mês, lembrando que o mês no CALENDAR começa com zero.		
			 if(year == c_year && month == c_month) { 
				 // Se o ANO e MÊS informados como argumento forem iguais aos desse contrato faça.
				 sum += c.totalValue();
				 
			 }
		}
		return sum;
			                            
	}
		
	
}

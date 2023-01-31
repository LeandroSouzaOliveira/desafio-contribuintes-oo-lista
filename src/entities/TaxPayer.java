package entities;

public class TaxPayer {

	private static final double SERVICE_TAX = 0.15;
	private static final double CAPITAL_TAX = 0.2;

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public Double salaryTax() {
		double salaryMonth = this.salaryIncome / 12.0;
		if (salaryMonth < 3000.0) {
			return 0.0;
		} 
		else if (salaryMonth < 5000.0) {
			return this.salaryIncome * 0.1;
		} 
		else {
			return this.salaryIncome * 0.2;
		}
	}

	public Double serviceTax() {
		return this.servicesIncome * SERVICE_TAX;
	}

	public Double capitalTax() {
		return this.capitalIncome * CAPITAL_TAX;
	}

	public Double grossTax() {
		return salaryTax() + serviceTax() + capitalTax();
	}

	public Double taxRebate() {
		double ceiling = grossTax() * 0.3;
		double rebate = this.healthSpending + this.educationSpending;
		if (rebate > ceiling) {
			return ceiling;
		} 
		else {
			return rebate;
		}
	}

	public Double netTax() {
		return grossTax() - taxRebate();
	}

	@Override
	public String toString() {
		return "TaxPayer [salaryIncome=" + salaryIncome + ", servicesIncome=" + servicesIncome + ", capitalIncome="
				+ capitalIncome + ", healthSpending=" + healthSpending + ", educationSpending=" + educationSpending
				+ "]";
	}
}

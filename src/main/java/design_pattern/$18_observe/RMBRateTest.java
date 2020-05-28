package design_pattern.$18_observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author young
 * @Date 2020/5/28 19:44
 * @Desc
 **/
public class RMBRateTest {

    public static void main(String[] args) {
        Rate rate = new RMBRate();
        Company ic = new ImportComp();
        Company ec = new ExportComp();
        rate.add(ic);
        rate.add(ec);
        rate.change(1);
        rate.change(-3);
    }

}

interface Company {
    void response(int num);
}

class ImportComp implements Company {

    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了进口产品成本，提升了进口公司利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了进口产品成本，降低了进口公司利润率。");
        }
    }
}

class ExportComp implements Company {

    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
        }
    }
}

abstract class Rate {
    protected List<Company> companies = new ArrayList<>();

    public void add(Company company) {
        companies.add(company);
    }

    public void remove(Company company) {
        companies.remove(company);
    }

    public abstract void change(int num);
}

class RMBRate extends Rate {

    @Override
    public void change(int num) {
        for (Company company : companies) {
            company.response(num);
        }
    }
}

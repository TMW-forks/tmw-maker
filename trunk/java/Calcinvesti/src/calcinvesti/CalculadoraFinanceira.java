package calcinvesti;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculadoraFinanceira {
	public CalculadoraFinanceira(float aplicacaoMensal, float jurosDeInvestimento, int mesesAplicados) {
		this.aplicacaoMensal=aplicacaoMensal;
		this.jurosDeInvestimento=jurosDeInvestimento;
		this.mesesAplicados=mesesAplicados;
		calcInvestimento();
	}
	private float aplicacaoMensal=0, jurosDeInvestimento=0; private int mesesAplicados=0;
	private float aplicacaoMonetarioTotal=0, rendimentoMonetarioUltimoMes=0, rendimentoPercentualTotal=0, rendimentoMonetarioTotal=0, saldoMonetarioTotal=0;

	private void calcInvestimento(){
		float $AM = aplicacaoMensal;
		float $JR = jurosDeInvestimento;
		int $TA=mesesAplicados;

		int $RP=0; float $SA=0, $AT=0, $RT=0, $RUM=0;
		for (int $m = 0; $m < $TA; $m++) {
			//$SA+=$m<1?$AM:($SA+$AM)+(($SA+$AM)*($JR/100));
			$SA+=$AM;
			$AT+=$AM;
			if ($m >= 1) {
				$SA+=$SA*($JR / 100);
				$RT+=$SA*($JR / 100);
			}
			if($m==$TA-1){ $RUM=$SA*($JR / 100);}
		}
		aplicacaoMonetarioTotal=$AT;
		rendimentoMonetarioUltimoMes=$RUM;
		rendimentoPercentualTotal=$RT/$AT;
		rendimentoMonetarioTotal=$RT;
		saldoMonetarioTotal=$SA;
		//Runtime Executador = Runtime.getRuntime();
	}
	public float getAplicacaoMonetariaTotal() {
		return aplicacaoMonetarioTotal;
	}
	public float getRendimentoMonetarioUltimoMes() {
		return rendimentoMonetarioUltimoMes;
	}
	public float getRendimentoPercentualTotal() {
		return rendimentoPercentualTotal;
	}
	public float getRendimentoMonetarioTotal() {
		return rendimentoMonetarioTotal;
	}
	public float getSaldoMonetarioTotal() {
		return saldoMonetarioTotal;
	}

	public String getFarmatoMoedaNacional(Float Valor) {
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); //para formatar os numeros na moeda do Brasil.
		return moneyFormat.format(Double.parseDouble(String.valueOf(Valor)));
	}
	public String getArredondado(Float Valor, int Decimais) {
		BigDecimal numerao = new BigDecimal(Valor*100);
		numerao = numerao.setScale(Decimais,BigDecimal.ROUND_HALF_UP);
		return numerao.toString();
	}
}

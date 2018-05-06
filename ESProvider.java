public class ESProvider {

    private RuleParser ruleParser;

    public ESProvider() {
        this("parser/Rules.xml", "parser/Facts.xml");
    }

    private ESProvider(String rulesFilePath, String factsFilePath) {

    }

    private FactRepository factRepo;
    private RuleRepository ruleRepo;
    // private FactParser factParser;
    // private RuleParser ruleParser;

    // ESProvider(FactParser factParser, RuleParser ruleParser) {
    //     this.factRepo = getFactRepository();
    //     this.ruleRepo = getRuleRepository();
    //     this.factParser = factParser;
    //     this.ruleParser = ruleParser;
    // }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {
        return true;
    }

    public String evaluate() {
        return "tak";
    }

}
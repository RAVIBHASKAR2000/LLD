class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType type) {
        return switch (type) {
            case EQUAL -> new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
        };
    }
}

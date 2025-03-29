package Utility;

public class Constants {
    public static String INFO = "\uD83D\uDCD8 General Info and How to Use\\n\\n\" +\n" +
            "\n" +
            "                        \"1. Permutations\\n\" +\n" +
            "                        \"- Use when order matters.\\n\" +\n" +
            "                        \"- Example: Arranging 3 people out of 5 in a line.\\n\" +\n" +
            "                        \"- Formula:\\n\" +\n" +
            "                        \"  nPr = n! / (n - r)!\\n\\n\" +\n" +
            "\n" +
            "                        \"2. Combinations\\n\" +\n" +
            "                        \"- Use when order does not matter.\\n\" +\n" +
            "                        \"- Example: Choosing 3 out of 5 cards.\\n\" +\n" +
            "                        \"- Formula:\\n\" +\n" +
            "                        \"  nCr = n! / (r! × (n - r)!)\\n\\n\" +\n" +
            "\n" +
            "                        \"3. Geometric Progression (GP)\\n\" +\n" +
            "                        \"- A sequence where each term is multiplied by a constant.\\n\" +\n" +
            "                        \"- nth Term: an = a × r^(n - 1)\\n\" +\n" +
            "                        \"- Sum of n Terms (r ≠ 1): Sn = a × (1 - r^n) / (1 - r)\\n\\n\" +\n" +
            "\n" +
            "                        \"4. Binomial Distribution\\n\" +\n" +
            "                        \"- Models the number of successes in n independent trials with success probability p.\\n\" +\n" +
            "                        \"- Formula:\\n\" +\n" +
            "                        \"  P(X = k) = nCk × p^k × (1 - p)^(n - k)\\n\\n\" +\n" +
            "\n" +
            "                        \"5. Poisson Distribution\\n\" +\n" +
            "                        \"- Used for counting rare events over a time or space interval.\\n\" +\n" +
            "                        \"- Notation: X ~ P(λ), where λ > 0 is the average rate.\\n\" +\n" +
            "                        \"- Possible values: k = 0, 1, 2, ...\\n\" +\n" +
            "                        \"- P(X = k) = (λ^k × e^(-λ)) / k!\\n\" +\n" +
            "                        \"  → In Excel: poisson.dist(k; λ; false)\\n\" +\n" +
            "                        \"- P(X ≤ x) = e^(-λ) × Σ (λ^k / k!)\\n\" +\n" +
            "                        \"  → In Excel: poisson.dist(x; λ; true)\\n\" +\n" +
            "                        \"- Expected value and variance:\\n\" +\n" +
            "                        \"  E(X) = D(X) = λ\\n\\n\" +\n" +
            "\n" +
            "                        \"6. Moivre-Laplace Approximation\\n\" +\n" +
            "                        \"- Used to approximate a binomial distribution with a normal distribution.\\n\" +\n" +
            "                        \"- Works well when n is large and p is not near 0 or 1.\\n\" +\n" +
            "                        \"- Mean: μ = np\\n\" +\n" +
            "                        \"- Standard deviation: σ = √(np(1 - p))\\n\" +\n" +
            "                        \"- Use continuity correction when approximating.\\n\\n\" +\n" +
            "                        \"  Cases:\\n\" +\n" +
            "                        \"  - P(X ≤ b) ≈ Φ((b + 0.5 - μ) / σ)\\n\" +\n" +
            "                        \"  - P(X ≥ a) ≈ 1 - Φ((a - 0.5 - μ) / σ)\\n\" +\n" +
            "                        \"  - P(a ≤ X ≤ b) ≈ Φ((b + 0.5 - μ) / σ) - Φ((a - 0.5 - μ) / σ)\\n\" +\n" +
            "                        \"  (Φ(z) is the cumulative distribution function of the standard normal distribution)\\n\"";
    public static String PERMUTATIONFXML = "permutation-popup.fxml";
    public static String PERMUTATIONFORMULA = "n! / (n - r)!";
    public static String COMBINATIONFXML = "combination-popup.fxml";
    public static String COMBINATIONFORMULA;
    public static String PROGRESSIONFXML = "progression-popup.fxml";
    public static String PROGRESSIONFORMULA;
    public static String BINOMIALFXML = "binomial-popup.fxml";
    public static String BINOMIALFORMULA;
    public static String POISSONFXML = "poisson-popup.fxml";
    public static String POISSONFORMULA;
    public static String MUAVREANDLAPLACEFXML = "muavre-and-laplace-popup.fxml";
    public static String MUAVREANDLAPLACEFORMULA;
}

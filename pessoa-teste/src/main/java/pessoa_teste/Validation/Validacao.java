package pessoa_teste.Validation;

public class Validacao {

    public static String avaliarCategoriaIdade(int idade) {
        if (idade < 18) {
            return "de menor";
        } else if (idade >= 18 && idade < 60) {
            return "adulto";
        } else {
            return "idoso";
        }
    }
}


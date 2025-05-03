package exercicios;

import exercicios.base.Aula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.toList;

/**
 * Esta é uma classe para você poder implementar as atividades propostas no README.
 * Você <b>NÃO</b> deve alterar:
 * <ul>
 *     <li>a estrutura deste arquivo;</li>
 *     <li>o nome da classe, dos métodos ou dos atributos;</li>
 *     <li>parâmetros e tipo de retorno dos métodos.</li>
 * </ul>
 *
 * <b>Mas você PRECISA alterar valores dos atributos existentes</b>.
 *
 * <p>Você pode alterar o código interno dos métodos, criar métodos auxiliares que podem ser chamados
 * pelos existentes, mas não deve alterar a estrutura dos métodos disponíveis.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Aula06 extends Aula {
    /**
     * {@link Predicate<Estudante>} que seleciona somente as mulheres
     * matriculadas em algum curso e com nota maior ou igual a 6.
     * Este deve ser um predicado composto usando {@link Predicate#and(Predicate)}.
     * Você deve trocar o valor armazenado ao atributo para ele seguir a regra definida acima.
     */
    private final Predicate<Estudante> mulheresAprovadas = ((Predicate<Estudante>) Estudante::isMulher).and(Estudante::hasCurso).and(Estudante::isAprovado);

    /**
     * Você pode chamar os métodos existentes e outros que você criar aqui,
     * incluir prints e fazer o que desejar neste método para conferir os valores retornados pelo seu método.
     * Para verificar se sua implementação está correta, clique com o botão direito no nome do projeto na aba esquerda
     * do IntelliJ e selecione a opção "Run All Tests".
     */
    public Aula06() {
        //TODO: Insira chamdas das funções existentes aqui, para você conferir como estão funcionando
        System.out.println("Lista 1: Mulheres Aprovadas");
        var lista1 = new ArrayList<>(getEstudantesMulheresAprovadas());
        for (Estudante estudante : lista1) {
            System.out.println(estudante);
        }
        System.out.println("Lista 2: Mulheres Aprovadas Ordenado Por Curso e Nota");
        var lista2 = new ArrayList<>(getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota());
        for (Estudante estudante : lista2) {
            System.out.println(estudante);
        }
        System.out.println("Lista 3: Mulheres Aprovadas Ordenado Por Curso Decescente e Nota Crescente");
        var lista3 = new ArrayList<>(getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente());
        for (Estudante estudante : lista3) {
            System.out.println(estudante);
        }
        System.out.println("Lista 4: Mulheres Aprovadas Não modificavel");
        var lista4 = new ArrayList<>(getEstudantesMulheresAprovadasNaoOrdenadasModificavel());
        for (Estudante estudante : lista4) {
            System.out.println(estudante);
        }
        System.out.println("Lista 5: Mulheres Aprovadas Ordenado Decrescente");
        var lista5 = new ArrayList<>(getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente());
        for (Estudante estudante : lista5) {
            System.out.println(estudante);
        }
        System.out.println("Lista 6: Mulheres Aprovadas Ordenado Por Curso Crescente e Nota Decrescente");
        var lista6 = new ArrayList<>(getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente());
        for (Estudante estudante : lista6) {
            System.out.println(estudante);
        }

    }

    /**
     * Veja o método construtor {@link #Aula06()}.
     */
    public static void main(String[] args) {
        new Aula06();
    }

    /**
     * Obtém uma Lista <b>NÃO-MODIFICÁVEL</b> de mulheres matriculadas e aprovadas em algum curso
     * O método usa o predicado {@link #mulheresAprovadas} para filtrar a lista de estudantes.
     * Desta forma, você precisa definir um predicado composto com {@link Predicate#and(Predicate)}
     * para tal atributo.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadas() {
        return estudantes
                .stream()
                .filter(mulheresAprovadas)
                .toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada por curso e nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        var cursoAndNota =
                comparing(Estudante::getCurso)
                .thenComparingDouble(Estudante::getNota);

        return estudantes
                .stream()
                .filter(mulheresAprovadas)
                .sorted(cursoAndNota)
                .toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma decrescente pelo nome do curso e crescente pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        var cursoDecrescenteAndNotaCrescente =
                comparing(Estudante::getCurso)
                .reversed()
                .thenComparingDouble(Estudante::getNota);

        return estudantes
                .stream()
                .filter(mulheresAprovadas)
                .sorted(cursoDecrescenteAndNotaCrescente)
                .toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas na ordem original retornada pela Stream.
     * A lista deve ser <b>MODIFICÁVEL</b>.
     *
     * @return uma Lista <b>MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return estudantes
                .stream()
                .filter(mulheresAprovadas)
                .collect(toList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma decrescente tanto pelo nome do curso quanto pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        var decrescente =
                comparing(Estudante::getCurso)
                .thenComparingDouble(Estudante::getNota)
                .reversed();

        return estudantes
                .stream()
                .filter(mulheresAprovadas)
                .sorted(decrescente)
                .toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma crescente pelo nome do curso e descrecente pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        var ordemNota =
                comparingDouble(Estudante::getNota)
                .reversed();
        var cursoCrescenteAndNotaDecrescente =
                comparing(Estudante::getCurso)
                .thenComparing(ordemNota);

        return estudantes
                .stream()
                .filter(mulheresAprovadas)
                .sorted(cursoCrescenteAndNotaDecrescente)
                .toList();
    }
}

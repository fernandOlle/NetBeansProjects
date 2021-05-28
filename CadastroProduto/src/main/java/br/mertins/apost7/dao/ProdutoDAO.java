package br.mertins.apost7.dao;

import br.mertins.apost7.bean.Produto;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author owzi
 */
public class ProdutoDAO {

    private static Map<Integer, Produto> baseDadosProduto = new TreeMap<>();

    public void insere(Produto produto) {
        baseDadosProduto.put(produto.getCod(), produto);
    }

    public void atualiza(Produto produto) {
        baseDadosProduto.put(produto.getCod(), produto);
    }

    public void remove(Produto produto) {
        baseDadosProduto.remove(produto.getCod());
    }

    public Produto encontraProCod(Integer cod) {
        return (Produto) baseDadosProduto.get(cod);
    }

    public Collection encontraTodos() {
        return baseDadosProduto.values();
    }
}
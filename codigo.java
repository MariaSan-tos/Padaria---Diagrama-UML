import java.util.ArrayList;
import java.util.List;

// Interface
interface Imprimivel {
    void imprimirDetalhes();
}

// Classe Cliente
class Cliente {
    private String nome;
    private String endereco;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}

// Classe Produto
class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

// Classe Pedido (Agregação de Cliente e Produto)
class Pedido implements Imprimivel {
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Cliente: " + cliente.getNome() + " | Endereço: " + cliente.getEndereco());
        System.out.println("Produtos no pedido:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + ": R$" + produto.getPreco());
        }
    }
}

// Classe Pastelaria (Composição de Pedido)
class Pastelaria {
    private String nome;
    private List<Pedido> pedidos;

    public Pastelaria(String nome) {
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("Pedidos na " + nome + ":");
        for (Pedido pedido : pedidos) {
            pedido.imprimirDetalhes();
        }
    }
}

// Classe principal para execução
public class Main {
    public static void main(String[] args) {
        // Criando objetos Cliente e Produto
        Cliente cliente1 = new Cliente("Maria", "Rua 123");
        Produto produto1 = new Produto("Pastel de Queijo", 5.00);
        Produto produto2 = new Produto("Pastel de Carne", 6.50);

        // Criando pedido e adicionando produtos
        Pedido pedido1 = new Pedido(1, cliente1);
        pedido1.adicionarProduto(produto1);
        pedido1.adicionarProduto(produto2);

        // Criando pastelaria e adicionando pedidos
        Pastelaria pastelaria = new Pastelaria("Pastelaria Alarosê");
        pastelaria.adicionarPedido(pedido1);

        // Listando pedidos na pastelaria
        pastelaria.listarPedidos();
    }
}

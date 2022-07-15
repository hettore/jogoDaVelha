
import java.awt.Font;
import java.awt.event.ActionEvent;

//Uso da biblioteca swing.
import javax.swing.*;

public class JogoDaVelha extends JFrame {
	
	//Adicinando a label para saber de quem é a vez.
	JLabel jogador = new JLabel("Jogador X"); 
	
	//Vetor de botões, definindo quantos botões teremos.
	JButton[] bt = new JButton[9];
	
	//Label para identificar o placar.
	JLabel placar = new JLabel("Placar");
	
	//Pontuação do X.
	JLabel px = new JLabel("X - 0");
	
	//Pontuação do O.
	JLabel po = new JLabel("O - 0");
	
	//Pontuação da Velha.
	JLabel vl = new JLabel("Velha - 0");
	
	//Botão de novo jogo.
	JButton novo = new JButton("Novo Jogo");
	
	//Botão zerar placar.
	JButton zerar = new JButton("Zerar Placar");
	int PX = 0;
	int PO = 0;
	int VL = 0;
	boolean xo = false;
	
	//Arrumando o click alternável em cada click uma vez X outra vez O.
	boolean[] click = new boolean[9];

	public JogoDaVelha() {
		
		//Janela visível 
		setVisible(true);
		setTitle("Jogo da velha #");
		
		//Finalizar a execução do programa quando clicar no x (fechar)
		setDefaultCloseOperation(3);
		
		//Usado para que possamos definir o layout
		setLayout(null);
		
		/*Os dois primeiors parametros indicão a orientação em que 
		a janela vai abrir e os dois na sequencia indicão o tamanho da janela*/
		setBounds(250, 100, 625, 425);
		
		//Adicionando a label placar.
		add (placar);
		
		//Adicionando o botão novo jogo.
		add (novo);
		
		//Adicionando o botão zerar placar.
		add (zerar);
		
		//Adicionando o contador de vitorias do X.
		add (px);
		
		//Adicionando o contador de vitorias do 0.
		add (po);
		
		//Adicionando a label para saber de quem é a vez.
		add (jogador);
		
		//Adiconando a label para contar quantas vezes a velha ganhou (o empate).
		add (vl);
		
		//Definindo tamanho e posição, na sequência de botões e labels.
		placar.setBounds(425,50,100,30);
		px.setBounds(400,75,100,30);
		po.setBounds(450,75,100,30);
		vl.setBounds(500,75,100,30);
		novo.setBounds(410,130,140,30);
		zerar.setBounds(410,180,140,30);
		jogador.setBounds(165,10,100,30);
		
		//Definindo o que acontece ao clicar em novo jogo.
		novo.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		
		//Definindo o que acontece quando clicamos em zerar placar.
		zerar.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PO = 0;
				PX = 0;
				VL = 0;
				atualizar();
			}
		});
		
		
		//Variável contadora inteira.
		int cont = 0;
		
		//Adicionando o elemento do botão.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bt[cont] = new JButton();
				add(bt[cont]);
				
				//definindo a posição do botão e tamanho dos botões.
				bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
				
				//definindo a fonte do botão.
				bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
				cont++;
			}
		}
		for (int i = 0; i < 9; i++) {
			click[i] = false;
		}
		//definindo o clicar para cada botão na sua posição.
		bt[0].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[0] == false) {
					click[0] = true;
					mudar(bt[0]);
				}
			}
		});

		bt[1].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[1] == false) {
					click[1] = true;
					mudar(bt[1]);
				}
			}
		});
		bt[2].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[2] == false) {
					click[2] = true;
					mudar(bt[2]);
				}
			}
		});
		bt[3].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[3] == false) {
					click[3] = true;
					mudar(bt[3]);
				}
			}
		});
		bt[4].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[4] == false) {
					click[4] = true;
					mudar(bt[4]);
				}
			}
		});
		bt[5].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[5] == false) {
					click[5] = true;
					mudar(bt[5]);
				}
			}
		});
		bt[6].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[6] == false) {
					click[6] = true;
					mudar(bt[6]);
				}
			}
		});
		bt[7].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[7] == false) {
					click[7] = true;
					mudar(bt[7]);
				}
			}
		});
		bt[8].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[8] == false) {
					click[8] = true;
					mudar(bt[8]);
				}
			}
		});

	}
	//Esquema para mudar a vez de cada jogador.
	public void mudar(JButton btn) {
		if (xo) {
			btn.setText("O");
			xo = false;
		} else {
			btn.setText("X");
			xo = true;
		}
		//Pra informar lá na label de quem é a vez.
		if(xo){
            jogador.setText("Jogador O ");
		}else{
            jogador.setText("Jogador X");
		}
		
		ganhou();
	}
	//Atualizar a pontuação dos jogadores.
	public void atualizar() {
		px.setText("X - " + PX);
		po.setText("O - " + PO);
		vl.setText("Velha - " + VL);
	}
	
	
	public void ganhou() {
		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if(click[i] == true) {
				cont++;
			}
		}
		//definindo as possições possíveis de ganho para a jogada com X.(lembrar q começa com 0)
		if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X") 
			||	(bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
			||	(bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
			||	(bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
			||	(bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
			||	(bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
			||	(bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
			||	(bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
			JOptionPane.showMessageDialog(null, "X, Ganhou!");
			PX++;
			atualizar();
			limpar();
			//definindo as possições possíveis de ganho para a jogada com O.(lembrar q começa com 0)
		}else if ((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O") 
				||	(bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
				||	(bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
				||	(bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
				||	(bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
				||	(bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
				||	(bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
				||	(bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
				JOptionPane.showMessageDialog(null, "O, Ganhou!");
				PO++;
				atualizar();
				limpar();
				
			//Criando o empate. Se conto for = 9 indica que todos os botões já foram pressionados
			}else if(cont == 9) {
				JOptionPane.showMessageDialog(null, "Deu VELHA, Empate!");
				VL++;
				atualizar();
				limpar();
				
			}
	}
	//Criando método para limpar as posições selecionadas
	public void limpar() {
		for (int i = 0; i < 9; i++) {
			bt[i].setText("");
			click[i] = false;
			//adicionando
			
		}
	}
	
	public static void main(String[] args) {
		new JogoDaVelha();
	}

}

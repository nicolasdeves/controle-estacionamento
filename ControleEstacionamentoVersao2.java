public class ControleEstacionamentoVersao2{
  public static void main (String args[]){
    String menu = " CONTROLE ESTACIONAMENTO \n\n"+
      "[C] ENTRAR CARRO \n"+
      "[M] ENTRAR MOTO \n"+
      "[V] SAIR CARRO \n"+
      "[N] SAIR MOTO \n"+
      "[D] CONSULTAR DADOS \n"+
      "[Z] ZERAR DADOS \n"+
      "[X] SAIR E SALVAR \n\n"+
      "DIGITE UMA OPCAO \n";
    
    String opcao = " ";
    
    int carros = 0;
    int motos = 0;
    
    int maxCarros = 3;
    int maxMotos = 2;
    
    int carrosDia = 0;
    int motosDia = 0;
    
    System.out.println("----CONTROLE ESTACIONAMENTO----");
    System.out.println();
    Arquivo estacionamento = new Arquivo ("ControleEstacionamento.txt");
        estacionamento.abrirLeitura();
        boolean teste = true;
        
        while(teste == true){
      
          String n = estacionamento.lerLinha();
          
          if (n == null){
            teste = false;
          }
          
          else{
            System.out.println(n);
          }
        }
        estacionamento.fecharArquivo();
        
        
    while(!opcao.equals("X")){
      
      int vagasCarro = (maxCarros - carros);
      int vagasMoto = (maxMotos - motos);
      
      opcao = Entrada.leiaString(menu + "\n Vagas de carro: " + vagasCarro + "/" + maxCarros + " \n Vagas moto: " + vagasMoto+ "/" + maxMotos).toUpperCase();
      
      if(opcao.equals("C")){
        if (carros == maxCarros){
          System.out.println("Estacionamento para carros CHEIO");
        }
        else{
          carros++;
          carrosDia++;
          System.out.println("Carro registrado!");
        }
      }
      
      if(opcao.equals("M")){
        if (motos == maxMotos){
          System.out.println("Estacionamento para motos CHEIO");
        }
        else{
          motos++;
          motosDia++;
          System.out.println("Moto registrada!");
        }
      }
      
      if(opcao.equals("V")){
        if (carros == 0){
          System.out.println("Estacionamento para carros VAZIO");
        }
        else{
          System.out.println("Carro saiu");
          carros--;
        }
      }
      
      if(opcao.equals("N")){
        if (motos == 0){
          System.out.println("Estacionamento para motos VAZIO");
        }
        else{
          System.out.println("Moto saiu");
          motos--;
        }
      }
      
      if (opcao.equals("Z")){
        boolean confirmacao = Entrada.leiaBoolean("Deseja realmente zerar os dados?", "Sim", "N�o");
        
        if(confirmacao == true){
          carros = 0;
          motos = 0;
          System.out.println("Sistema ZERADO");
        }
        
        
      }
      
      if (opcao.equals("D")){
        System.out.println("---- DADOS ----");
        System.out.println();
        System.out.println("Vagas de carro dispon�veis: " + vagasCarro);
        System.out.println("Vagas de moto dispon�veis: " + vagasMoto);
        System.out.println();
        System.out.println("Carros estacionados no momentos: " + carros);
        System.out.println("Motos estacionadas no momento: " + motos);
        System.out.println();
        System.out.println("Total de carros hoje: " + carrosDia);
        System.out.println("Vagas de motos hoje: " + motosDia);
        
        
      }
      
      if (opcao.equals("X")){
        System.out.println("Voc� fechou o programa");
        System.out.println("-----Total de ve�culos hoje-----");
        System.out.println("Carros: " + carrosDia + "\nMotos: " + motosDia);
        
        Arquivo controle = new Arquivo ("ControleEstacionamento.txt");
        controle.abrirEscrita();
        controle.escreverLinha("||||Quantidade de ve�culos hoje|||| \nCarros: " + carrosDia + "\nMotos: " + motosDia + "\nTotal: " + (carrosDia+motosDia));
        controle.escreverLinha("||||Quantidade de ve�culos agora|||| \nCarros: " + carros+ "\nMotos: " + motos);
        controle.fecharArquivo();
      }
      
      
      
    }
  }
}
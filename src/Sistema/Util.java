//Classe para criar tabelas (substituir nosso terminal),,
package Sistema;

//import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;

public class Util {
        public Connection conecta() throws SQLException {
                      Connection conexao = null;

        String url = "jdbc:mysql://localhost/";  //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = "123456"; //senha do MySQL
        try{
            conexao = DriverManager.getConnection(url, user, password);
}catch(SQLException sqlex){
System.out.println("Erro na conexão "+ sqlex);
}
        return conexao;
    }

public static void criaTabela(String nomeTabela,String atributos) throws SQLException {
            Statement statement = null;
            Connection conexao = null;
        try {
            conexao = conecta();
            statement = conexao.createStatement();
            String createTableSQL = "CREATE TABLE "+nomeTabela+"("+atributos+")";
            System.out.println(createTableSQL);
               statement.execute(createTableSQL); // executa o comando de criação
            System.out.println("Tabela \"nomeTabela\" foi criada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {   // sempre feche o statement a conexão com banco
            if (statement != null) {
                statement.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }
    public static void criaBanco(String banco) throws SQLException {    
           String sql = "CREATE DATABASE"+banco;
           Connection conexao = conecta();
           Statement stmt = conexao.createStatement();
           stmt.execute(sql);
    } 
    
    public static void main(String[] args)throws SQLException{
        //cria o banco petshop
        criaBanco("Petshop");
        //criar as tabelas
        criaTabela("Dono","`ID` INT NULL AUTO_INCREMENT,"+
  "`CPF` VARCHAR(11) NULL,"+
  "`Endereco` VARCHAR(45) NULL,"+
  "`Telefone` VARCHAR(45) NULL,"+
  "`Nome` VARCHAR(45) NULL,"+
  "`Nascimento` VARCHAR(45) NULL,"+
  "PRIMARY KEY (`ID`)");
        criaTabela("Animal","`idAnimal` INT NULL AUTO_INCREMENT,\n" +
"  `Raca` VARCHAR(45) NULL,\n" +
"  `Cor` VARCHAR(45) NULL,\n" +
"  `Tamanho` VARCHAR(20) NULL,\n" +
"  `Obs` VARCHAR(45) NULL,\n" +
"  `Nome` VARCHAR(45) NULL,\n" +
"  `Nascimento` VARCHAR(45) NULL,\n" +
"  `Dono_ID` INT NOT NULL,\n" +
"  PRIMARY KEY (`idAnimal`, `Dono_ID`),\n" +
"  INDEX `fk_Animal_Dono1_idx` (`Dono_ID` ASC),\n" +
"  CONSTRAINT `fk_Animal_Dono1`\n" +
"    FOREIGN KEY (`Dono_ID`)\n" +
"    REFERENCES `mydb`.`Dono` (`ID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION");
        criaTabela("Serviço","  `ID` INT NULL AUTO_INCREMENT,\n" +
"  `Nome` VARCHAR(45) NULL,\n" +
"  `Descricao` VARCHAR(45) NULL,\n" +
"  PRIMARY KEY (`ID`))\n" +
"ENGINE = InnoDB;");
        criaTabela("Agenda","`Horario` INT NULL,\n" +
"  `ID` INT NULL AUTO_INCREMENT,\n" +
"  `Animal_idAnimal` INT NOT NULL,\n" +
"  `Servico_ID` INT NOT NULL,\n" +
"  PRIMARY KEY (`ID`, `Animal_idAnimal`, `Servico_ID`),\n" +
"  INDEX `fk_Agenda_Animal_idx` (`Animal_idAnimal` ASC),\n" +
"  INDEX `fk_Agenda_Servico1_idx` (`Servico_ID` ASC),\n" +
"  CONSTRAINT `fk_Agenda_Animal`\n" +
"    FOREIGN KEY (`Animal_idAnimal`)\n" +
"    REFERENCES `mydb`.`Animal` (`idAnimal`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_Agenda_Servico1`\n" +
"    FOREIGN KEY (`Servico_ID`)\n" +
"    REFERENCES `mydb`.`Servico` (`ID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION");
    }
}  
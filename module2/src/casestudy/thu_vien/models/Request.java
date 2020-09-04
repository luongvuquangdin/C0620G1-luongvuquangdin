package casestudy.thu_vien.models;


import casestudy.thu_vien.commons.ReadFileObject;
import casestudy.thu_vien.commons.WriteFileObject;
import casestudy.thu_vien.commons.WriteFileText;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Request {
    private String action;
    private List<Entities> params;
    private String keyword;
    private Scanner scanner = new Scanner(System.in);

    public Request(String action, List<Entities> params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public Request() {
        params = new ArrayList<>();
    }


    public List<Entities> getParams() {
        return params;
    }

    public void setParams(ArrayList<Entities> params) {
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public void checkAction() {
        this.params = ReadFileObject.read();
        if (this.action.equals("lookup")) lookup();
        else if (this.action.equals("define")) define();
        else if (this.action.equals("export")) export();
        else drop();
    }

    private void lookup() {
        boolean isSearch = false;
        System.out.print(this.keyword);
        if (params.size() != 0) {
            for (Entities entities : params) {
                if (entities.getKeyword().equals(this.keyword)) {
                    System.out.println(entities.toString());
                    isSearch = true;
                }
            }
        }
        if (!isSearch) {
            System.out.println(" don't exits");
        }
    }

    private void define() {
        //Khởi tạo đối tượng từ vựng
        Entities entities = new Entities();

        //Nhập thuộc tính type loại từ cho entities
        String type = null;
        do {
            System.out.print("Type of word: ");
            type = scanner.nextLine();
        } while (!type.matches("^((verb)|(adjective)|(noun)|(pronoun)|(articles))$"));
        entities.setType(type);
        if (params.size() != 0) {
            for (Entities entities_1 : params) {
                boolean isExitsKeyWord=entities_1.getKeyword().equals(this.keyword);
                boolean isExitsTypeWord=entities_1.getType().equals(entities.getType());
                if (isExitsKeyWord&&isExitsTypeWord){
                        System.out.println(this.keyword + " exits");
                        return;
                    }
                }
            }
            //Set thuộc tính keyWord từ cho entities
            entities.setKeyword(this.keyword);

            //Nhập thuộc tính Mean nghĩa tiếng việt của từ cho entities
            System.out.print("Insert mean of word: ");
            String mean = scanner.nextLine();
            entities.setMean(mean);
            params.add(entities);
        WriteFileObject.write(params);
    }

    private void drop() {
        boolean isSearch=false;
        Entities entities = null;
        if (params.size() == 0) {
            System.out.println("Nothing");
            return;
        }
        if (params.size() != 0) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i).getKeyword().equals(this.keyword)) {
                    entities = params.get(i);
                    params.remove(entities);
                    isSearch=true;
                }
            }
        }
        if (isSearch==false){
            System.out.println(this.keyword + " don't have");
        }else {
            System.out.println(this.keyword+ " removed");
            WriteFileObject.write(params);
        }
    }

    private void export(){
        if (params.size()==0){
            System.out.println("Dictionary null");
            return;
        }
        WriteFileText.write(params,this.keyword);
        System.out.println("done");
    }

}

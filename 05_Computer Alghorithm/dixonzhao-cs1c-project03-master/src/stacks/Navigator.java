package stacks;


/**
 Use to simulate control of two stack list and one current list
 * @author Foothill College, Zhili Zhao
 */
public class Navigator {

    private String CurrentLink=null;
    private StackList<String> backLinks,forwardLinks;

    /**
     * default generator
     */
    Navigator(){
        backLinks=new StackList<String>();
        forwardLinks=new StackList<String>();
    }

    public void setCurrentLink(String linkContent){
        if(CurrentLink==null){
            CurrentLink=linkContent;
        } else{
            backLinks.push(CurrentLink);
            CurrentLink=linkContent;
        }
    }

    public void goBack(){
        if(backLinks.isEmpty()||backLinks.size()==0){
            System.out.println("No back link, remain same");
        } else{
            forwardLinks.push(CurrentLink);
            CurrentLink=backLinks.pop();
        }
    }

    public StackList<String> getBackLinks() {
        return backLinks;
    }

    public StackList<String> getForwardLinks() {
        return forwardLinks;
    }

    public void goForward(){
        if(forwardLinks.isEmpty()|| forwardLinks.size()==0){
            System.out.println("No forward link, remain same");
        } else{
            backLinks.push(CurrentLink);
            CurrentLink=forwardLinks.pop();
        }
    }

    public String getCurrentLink(){
        return CurrentLink;
    }

}

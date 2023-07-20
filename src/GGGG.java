import java.util.*;

class Person {
    private String name;
    private Gender gender;
    private List<Relation> relations = new ArrayList<>();

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addRelation(Relation relation) {
        relations.add(relation);
    }
}

class Relation {
    private TreeRelationType type;
    private Person person1;
    private Person person2;

    Relation(TreeRelationType type, Person person1, Person person2) {
        this.type = type;
        this.person1 = person1;
        this.person2 = person2;
    }

    public TreeRelationType getType() {
        return type;
    }

    public void setType(TreeRelationType type) {
        this.type = type;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }
}

enum TreeRelationType {
    SPOUSE, PARENT, CHILD
}

enum Gender {
    MALE, FEMALE
}

enum RelationType {
    FATHER, MOTHER, BROTHER, SISTER, SON, DAUGHTER, COUSIN, GRANDMOTHER, GRANDFATHER, GRANDSON, GRANDDAUGHTER, AUNT,
    UNCLE, HUSBAND, WIFE
}

class InvalidInputException extends Exception {
    static final long serialVersionUID = -3387516993334229948L;

    public InvalidInputException(String message) {
        super(message);
    }

}

class FamilyTree {
    private Person root;
    private Map<String, Boolean> visted = new HashMap<>();

    public Person getRoot() {
        return root;
    }

    public void setRoot(Person root) {
        this.root = root;
    }

    private Gender fetchGender(RelationType type) {
        if (RelationType.MOTHER.equals(type) || RelationType.DAUGHTER.equals(type) || RelationType.WIFE.equals(type))
            return Gender.FEMALE;
        else
            return Gender.MALE;
    }

    private TreeRelationType fetchTreeRelationType(RelationType type) {
        if (RelationType.MOTHER.equals(type) || RelationType.FATHER.equals(type))
            return TreeRelationType.CHILD;
        else if (RelationType.HUSBAND.equals(type) || RelationType.WIFE.equals(type))
            return TreeRelationType.SPOUSE;
        else
            return TreeRelationType.PARENT;
    }

    public void addPerson(String name1, RelationType type1, String name2, RelationType type2)
            throws InvalidInputException {
        TreeRelationType relationType1 = fetchTreeRelationType(type1);
        TreeRelationType relationType2 = fetchTreeRelationType(type2);
        Gender gender1 = fetchGender(type1);
        Gender gender2 = fetchGender(type2);
        if (this.root == null) {
            Person person1 = new Person(name1, gender1);
            Person person2 = new Person(name2, gender2);
            this.root = person1;
            addRelation(relationType1, person1, relationType2, person2);
        } else {
            Person person1 = findPerson(this.root, name1);
            if (person1 == null) {
                throw new InvalidInputException("Invalid Input");
            }
            Person person2 = new Person(name2, gender2);
            addRelation(relationType1, person1, relationType2, person2);
            if (TreeRelationType.CHILD.equals(relationType1)) {
                for (Relation relation : person1.getRelations()) {
                    if (TreeRelationType.SPOUSE.equals(relation.getType())) {
                        person1 = relation.getPerson2();
                        break;
                    }

                }
                addRelation(relationType1, person1, relationType2, person2);
            }

        }

    }

    private Person findPerson(Person cur, String name) {
        this.visted.put(cur.getName(), Boolean.TRUE);
        if (cur.getName().equals(name)) {
            this.visted.clear();
            return cur;

        } else {
            for (Relation relation : cur.getRelations()) {
                Person person2 = relation.getPerson2();
                if (!visted.containsKey(person2.getName())) {
                    Person person = findPerson(person2, name);
                    if (person != null) {
                        return person;
                    }
                }

            }
        }
        return null;

    }

    private void addRelation(TreeRelationType type1, Person person1, TreeRelationType type2, Person person2) {
        Relation relation1 = new Relation(type1, person1, person2);
        person1.addRelation(relation1);
        Relation relation2 = new Relation(type2, person2, person1);
        person2.addRelation(relation2);
    }

    private List<Person> fetchChildren(String name) throws InvalidInputException {
        List<Person> children = new ArrayList<>();
        Person person = findPerson(this.root, name);
        if (person == null) {
            throw new InvalidInputException("Invalid Input");
        }
        for (Relation relation : person.getRelations()) {
            if (TreeRelationType.CHILD.equals(relation.getType())) {
                children.add(relation.getPerson2());

            }
        }
        return children;
    }

    private List<Person> fetchParents(String name) throws InvalidInputException {
        List<Person> parents = new ArrayList<>();
        Person person = findPerson(this.root, name);
        if (person == null) {
            throw new InvalidInputException("Invalid Input");
        }
        for (Relation relation : person.getRelations()) {
            if (TreeRelationType.PARENT.equals(relation.getType())) {
                parents.add(relation.getPerson2());

            }
        }
        return parents;
    }

    private Person fetchFather(String name) throws InvalidInputException {
        Person father = null;
        List<Person> parents = fetchParents(name);
        for (Person person : parents) {
            if (Gender.MALE.equals(person.getGender()))
                father = person;
        }
        return father;
    }

    private Person fetchMother(String name) throws InvalidInputException {
        Person mother = null;
        List<Person> parents = fetchParents(name);
        for (Person person : parents) {
            if (Gender.FEMALE.equals(person.getGender()))
                mother = person;
        }
        return mother;
    }

    private List<Person> fetchSiblings(String name) throws InvalidInputException {
        List<Person> siblings = new ArrayList<>();
        Person father = fetchFather(name);
        if (father != null) {
            List<Person> children = fetchChildren(father.getName());
            for (Person person : children) {
                if (!person.getName().equals(name)) {
                    siblings.add(person);
                }
            }
        }
        return siblings;
    }

    private List<Person> fetchBrothers(String name) throws InvalidInputException {
        List<Person> brothers = new ArrayList<>();
        List<Person> siblings = fetchSiblings(name);
        for (Person person : siblings) {
            if (Gender.MALE.equals(person.getGender())) {
                brothers.add(person);
            }
        }
        return brothers;
    }

    private List<Person> fetchSisters(String name) throws InvalidInputException {
        List<Person> sisters = new ArrayList<>();
        List<Person> siblings = fetchSiblings(name);
        for (Person person : siblings) {
            if (Gender.FEMALE.equals(person.getGender())) {
                sisters.add(person);
            }
        }

        return sisters;
    }

    private List<Person> fetchSons(String name) throws InvalidInputException {
        List<Person> sons = new ArrayList<>();
        List<Person> children = fetchChildren(name);
        for (Person person : children) {
            if (Gender.MALE.equals(person.getGender())) {
                sons.add(person);
            }
        }
        return sons;
    }

    private List<Person> fetchDaugthers(String name) throws InvalidInputException {
        List<Person> daughters = new ArrayList<>();
        List<Person> children = fetchChildren(name);
        for (Person person : children) {
            if (Gender.FEMALE.equals(person.getGender())) {
                daughters.add(person);
            }
        }
        return daughters;
    }

    private List<Person> fetchCousins(String name) throws InvalidInputException {
        List<Person> cousins = new ArrayList<>();
        List<Person> parents = fetchParents(name);
        for (Person person : parents) {
            List<Person> siblings = fetchSiblings(person.getName());
            for (Person sibling : siblings) {
                List<Person> children = fetchChildren(sibling.getName());
                cousins.addAll(children);

            }

        }
        return cousins;
    }

    private List<Person> fetchGrandParents(String name) throws InvalidInputException {
        List<Person> grandParents = new ArrayList<>();
        List<Person> parents = fetchParents(name);
        for (Person person : parents) {
            grandParents.addAll(fetchParents(person.getName()));
        }
        return grandParents;
    }

    private Person fetchGrandMother(String name) throws InvalidInputException {
        Person grandMother = null;
        List<Person> grandParents = fetchGrandParents(name);
        for (Person person : grandParents) {
            if (Gender.FEMALE.equals(person.getGender())) {
                grandMother = person;
            }
        }
        return grandMother;
    }

    private Person fetchGrandFather(String name) throws InvalidInputException {
        Person grandFather = null;
        List<Person> grandParents = fetchGrandParents(name);
        for (Person person : grandParents) {
            if (Gender.MALE.equals(person.getGender())) {
                grandFather = person;
            }
        }
        return grandFather;
    }

    private List<Person> fetchGrandChildren(String name) throws InvalidInputException {
        List<Person> children = fetchChildren(name);
        List<Person> grandChildren = new ArrayList<>();
        for (Person person : children) {
            grandChildren.addAll(fetchChildren(person.getName()));
        }

        return grandChildren;
    }

    private List<Person> fetchGrandSons(String name) throws InvalidInputException {
        List<Person> grandSons = new ArrayList<>();
        List<Person> grandChildren = fetchGrandChildren(name);
        for (Person person : grandChildren) {
            if (Gender.MALE.equals(person.getGender())) {
                grandSons.add(person);
            }
        }

        return grandSons;
    }

    private List<Person> fetchGrandDaugthers(String name) throws InvalidInputException {
        List<Person> grandDaugthers = new ArrayList<>();
        List<Person> grandChildren = fetchGrandChildren(name);
        for (Person person : grandChildren) {
            if (Gender.FEMALE.equals(person.getGender())) {
                grandDaugthers.add(person);
            }
        }
        return grandDaugthers;
    }

    private List<Person> fetchAunts(String name) throws InvalidInputException {
        List<Person> aunts = new ArrayList<>();
        List<Person> parents = fetchParents(name);
        for (Person person : parents) {
            List<Person> siblings = fetchSiblings(person.getName());
            for (Person sibling : siblings) {
                if (Gender.FEMALE.equals(sibling.getGender())) {
                    aunts.add(sibling);
                } else {
                    Optional<Person> spouce = Optional.ofNullable(fetchSpouce(sibling.getName()));
                    if (spouce.isPresent()) {
                        aunts.add(spouce.get());
                    }

                }
            }
        }
        return aunts;
    }

    private List<Person> fetchUncles(String name) throws InvalidInputException {
        List<Person> uncles = new ArrayList<>();
        List<Person> parents = fetchParents(name);
        for (Person person : parents) {
            List<Person> siblings = fetchSiblings(person.getName());
            for (Person sibling : siblings) {
                if (Gender.MALE.equals(sibling.getGender())) {
                    uncles.add(sibling);
                } else {
                    Optional<Person> spouce = Optional.ofNullable(fetchSpouce(sibling.getName()));
                    if (spouce.isPresent()) {
                        uncles.add(spouce.get());
                    }

                }
            }
        }
        return uncles;
    }

    private Person fetchSpouce(String name) throws InvalidInputException {
        Person spouce = null;
        Person person = findPerson(this.root, name);
        if (person == null) {
            throw new InvalidInputException("Invalid Input");
        }
        for (Relation relation : person.getRelations()) {
            if (TreeRelationType.SPOUSE.equals(relation.getType())) {
                spouce = relation.getPerson2();
                break;
            }
        }
        return spouce;
    }

    public static void main(String args[]) throws InvalidInputException {
        FamilyTree tree = new FamilyTree();
        tree.addPerson("Evan", RelationType.HUSBAND, "Diana", RelationType.WIFE);
        tree.addPerson("Evan", RelationType.FATHER, "John", RelationType.SON);
        tree.addPerson("Evan", RelationType.FATHER, "Alex", RelationType.SON);
        tree.addPerson("Evan", RelationType.FATHER, "Joe", RelationType.SON);
        tree.addPerson("Evan", RelationType.FATHER, "Nisha", RelationType.DAUGHTER);
        tree.addPerson("Alex", RelationType.HUSBAND, "Nancy", RelationType.WIFE);
        tree.addPerson("Joe", RelationType.HUSBAND, "Niki", RelationType.WIFE);
        tree.addPerson("Nisha", RelationType.WIFE, "Adam", RelationType.HUSBAND);
        tree.addPerson("Alex", RelationType.FATHER, "Jacob", RelationType.SON);
        tree.addPerson("Alex", RelationType.FATHER, "Shaun", RelationType.SON);
        tree.addPerson("Joe", RelationType.FATHER, "Piers", RelationType.SON);
        tree.addPerson("Joe", RelationType.FATHER, "Sally", RelationType.DAUGHTER);
        tree.addPerson("Adam", RelationType.FATHER, "Ruth", RelationType.DAUGHTER);
        tree.addPerson("Adam", RelationType.FATHER, "Paul", RelationType.SON);
        tree.addPerson("Adam", RelationType.FATHER, "William", RelationType.SON);
        tree.addPerson("Jacob", RelationType.HUSBAND, "Rufi", RelationType.WIFE);
        tree.addPerson("Piers", RelationType.HUSBAND, "Pippa", RelationType.WIFE);
        tree.addPerson("Sally", RelationType.WIFE, "Owen", RelationType.HUSBAND);
        tree.addPerson("Ruth", RelationType.WIFE, "Neil", RelationType.HUSBAND);
        tree.addPerson("Paul", RelationType.HUSBAND, "Zoe", RelationType.WIFE);
        tree.addPerson("William", RelationType.HUSBAND, "Rose", RelationType.WIFE);
        tree.addPerson("Jacob", RelationType.FATHER, "Bern", RelationType.SON);
        tree.addPerson("Jacob", RelationType.FATHER, "Sophia", RelationType.DAUGHTER);
        tree.addPerson("Piers", RelationType.FATHER, "Sarah", RelationType.DAUGHTER);
        tree.addPerson("Paul", RelationType.FATHER, "Roger", RelationType.SON);
        tree.addPerson("William", RelationType.FATHER, "Steve", RelationType.SON);
        tree.addPerson("Sophia", RelationType.WIFE, "George", RelationType.HUSBAND);

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            try {
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                String inputString = sc.nextLine();
                if (!inputString.isEmpty()) {
                    String[] input = inputString.split(" ");
                    if (input[0].equals("exit")) {
                        sc.close();
                        System.exit(0);
                    }
                    if (input[0].contains("Person")) {
                        String[] person = input[0].split(" = ");
                        String[] relation = input[1].split(" = ");
                        String name = person[1];
                        String value = relation[1].toUpperCase();
                        if (value.charAt(value.length() - 1) == 'S') {
                            value = value.substring(0, value.length() - 1);
                        }

                        RelationType relationType = RelationType.valueOf(value);
                        switch (relationType) {

                            case FATHER:
                                Optional<Person> father = Optional.ofNullable(tree.fetchFather(name));
                                if (father.isPresent()) {
                                    System.out.println(relation[1] + " = " + tree.fetchFather(name).getName());
                                }
                                break;
                            case MOTHER:
                                Optional<Person> mother = Optional.ofNullable(tree.fetchMother(name));
                                if (mother.isPresent()) {
                                    System.out.println(relation[1] + " = " + tree.fetchMother(name).getName());
                                }
                                break;
                            case BROTHER:
                                System.out.println(relation[1] + " = " + tree.fetchBrothers(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(",")));
                                break;
                            case SISTER:
                                System.out.println(
                                        relation[1] + " = " + tree.fetchSisters(name).stream().map(Person::getName)
                                                .collect(Collectors.joining(",")));
                                break;
                            case SON:
                                System.out.println(
                                        relation[1] + " = " + tree.fetchSons(name).stream().map(Person::getName)
                                                .collect(Collectors.joining(",")));
                                break;
                            case DAUGHTER:
                                System.out.println(relation[1] + " = " + tree.fetchDaugthers(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(",")));
                                break;
                            case COUSIN:
                                System.out.println(
                                        relation[1] + " = " + tree.fetchCousins(name).stream().map(Person::getName)
                                                .collect(Collectors.joining(",")));
                                break;
                            case GRANDMOTHER:
                                Optional<Person> grandMother = Optional.ofNullable(tree.fetchGrandMother(name));
                                if (grandMother.isPresent()) {
                                    System.out.println(relation[1] + " = " + tree.fetchGrandMother(name).getName());
                                }
                                break;
                            case GRANDFATHER:
                                Optional<Person> grandFather = Optional.ofNullable(tree.fetchGrandFather(name));
                                if (grandFather.isPresent()) {
                                    System.out.println(relation[1] + " = " + tree.fetchGrandFather(name).getName());
                                }
                                break;
                            case GRANDSON:
                                System.out.println(relation[1] + " = " + tree.fetchGrandSons(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(",")));
                                break;
                            case GRANDDAUGHTER:
                                System.out.println(relation[1] + " = " + tree.fetchGrandDaugthers(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(",")));
                                break;
                            case AUNT:
                                System.out.println(
                                        relation[1] + " = " + tree.fetchAunts(name).stream().map(Person::getName)
                                                .collect(Collectors.joining(",")));
                                break;
                            case UNCLE:
                                System.out.println(
                                        relation[1] + " = " + tree.fetchUncles(name).stream().map(Person::getName)
                                                .collect(Collectors.joining(",")));
                                break;
                            case HUSBAND:
                            case WIFE:
                                Optional<Person> spouce = Optional.ofNullable(tree.fetchSpouce(name));
                                if (spouce.isPresent()) {
                                    System.out.println(relation[1] + " = " + tree.fetchSpouce(name).getName());
                                }
                                break;
                        }
                    } else {
                        String name1 = input[0].split(" = ")[1];
                        String name2 = input[1].split(" = ")[1];
                        RelationType type1 = RelationType.valueOf(input[0].split(" = ")[0].toUpperCase());
                        RelationType type2 = RelationType.valueOf(input[1].split(" = ")[0].toUpperCase());
                        tree.addPerson(name1, type1, name2, type2);
                        System.out.println("Welcome to the family, " + name2 + "!");
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
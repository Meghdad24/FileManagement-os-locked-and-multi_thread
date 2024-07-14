import java.io.IOException;

public class ClientSimulation {
    private static final String hostname = "localhost";
    private static final int port = 9999;

    public static void main(String[] args) throws InterruptedException {
        phase1(); //Creating files by multi thread
        phase2(); //Writing on files by multi thread and LOCK
        phase3(); //Reading from files by multi thread
        phase4(); //Reading and Writing
    }

    private static void phase4() throws InterruptedException {
        System.out.println("\n\nPHASE4\n\n");
        BasicClient client1 = new BasicClient(hostname, port);
        BasicClient client2 = new BasicClient(hostname, port);
        BasicClient client3 = new BasicClient(hostname, port);
        BasicClient client4 = new BasicClient(hostname, port);

        Thread t1 = new Thread(() -> {
            try {
                client1.sendCommand("WRITE__1file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 1");
                System.out.println("11 Response from server: " + client1.receiveResponse());

                client1.sendCommand("READ__6file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                System.out.println("12 Response from server: " + client1.receiveResponse());

                client1.sendCommand("WRITE__7file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 7");
                System.out.println("13 Response from server: " + client1.receiveResponse());

                client1.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                System.out.println("14 Response from server: " + client1.receiveResponse());

                client1.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("15 Response from server: " + client1.receiveResponse());

            } catch (IOException e) {

            } finally {
                client1.close();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                client2.sendCommand("WRITE__3file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 3");
                System.out.println("21 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__5file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 5");
                System.out.println("22 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__2file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("23 Response from server: " + client2.receiveResponse());

                client2.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("24 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                System.out.println("25 Response from server: " + client2.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client2.close();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                client3.sendCommand("READ__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 4");
                System.out.println("31 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__8file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 8");
                System.out.println("32 Response from server: " + client3.receiveResponse());

                client3.sendCommand("READ__9file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 9");
                System.out.println("33 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("34 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("35 Response from server: " + client3.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client3.close();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                client4.sendCommand("READ__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 4");
                System.out.println("41 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__8file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 8");
                System.out.println("42 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__9file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 9");
                System.out.println("43 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__3file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("44 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__1file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("45 Response from server: " + client4.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client4.close();
            }
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

    private static void phase3() throws InterruptedException {
        System.out.println("\n\nPHASE3\n\n");
        BasicClient client1 = new BasicClient(hostname, port);
        BasicClient client2 = new BasicClient(hostname, port);
        BasicClient client3 = new BasicClient(hostname, port);
        BasicClient client4 = new BasicClient(hostname, port);

        Thread t1 = new Thread(() -> {
            try {
                client1.sendCommand("READ__1file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 1");
                System.out.println("11 Response from server: " + client1.receiveResponse());

                client1.sendCommand("READ__6file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 6");
                System.out.println("12 Response from server: " + client1.receiveResponse());

                client1.sendCommand("READ__7file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 7");
                System.out.println("13 Response from server: " + client1.receiveResponse());

                client1.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("14 Response from server: " + client1.receiveResponse());

                client1.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("15 Response from server: " + client1.receiveResponse());

            } catch (IOException e) {

            } finally {
                client1.close();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                client2.sendCommand("READ__3file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 3");
                System.out.println("21 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__5file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 5");
                System.out.println("22 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__2file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("23 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("24 Response from server: " + client2.receiveResponse());

                client2.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("25 Response from server: " + client2.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client2.close();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                client3.sendCommand("READ__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 4");
                System.out.println("31 Response from server: " + client3.receiveResponse());

                client3.sendCommand("READ__8file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 8");
                System.out.println("32 Response from server: " + client3.receiveResponse());

                client3.sendCommand("READ__9file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 9");
                System.out.println("33 Response from server: " + client3.receiveResponse());

                client3.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("34 Response from server: " + client3.receiveResponse());

                client3.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("35 Response from server: " + client3.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client3.close();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                client4.sendCommand("READ__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 4");
                System.out.println("41 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__8file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 8");
                System.out.println("42 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__9file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 9");
                System.out.println("43 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("44 Response from server: " + client4.receiveResponse());

                client4.sendCommand("READ__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("45 Response from server: " + client4.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client4.close();
            }
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

    private static void phase2() throws InterruptedException {
        System.out.println("\n\nPHASE2\n\n");
        BasicClient client1 = new BasicClient(hostname, port);
        BasicClient client2 = new BasicClient(hostname, port);
        BasicClient client3 = new BasicClient(hostname, port);

        Thread t1 = new Thread(() -> {
            try {
                client1.sendCommand("WRITE__1file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 1");
                System.out.println("11 Response from server: " + client1.receiveResponse());

                client1.sendCommand("WRITE__6file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 6");
                System.out.println("12 Response from server: " + client1.receiveResponse());

                client1.sendCommand("WRITE__7file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 7");
                System.out.println("13 Response from server: " + client1.receiveResponse());

                client1.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("14 Response from server: " + client1.receiveResponse());

                client1.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("15 Response from server: " + client1.receiveResponse());

            } catch (IOException e) {

            } finally {
                client1.close();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                client2.sendCommand("WRITE__3file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 3");
                System.out.println("21 Response from server: " + client2.receiveResponse());

                client2.sendCommand("WRITE__5file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 5");
                System.out.println("22 Response from server: " + client2.receiveResponse());

                client2.sendCommand("WRITE__2file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 2");
                System.out.println("23 Response from server: " + client2.receiveResponse());

                client2.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("24 Response from server: " + client2.receiveResponse());

                client2.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("25 Response from server: " + client2.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client2.close();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                client3.sendCommand("WRITE__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 4");
                System.out.println("31 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__8file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 8");
                System.out.println("32 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__9file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__START File 9");
                System.out.println("33 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("34 Response from server: " + client3.receiveResponse());

                client3.sendCommand("WRITE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files__WRITE TEST");
                System.out.println("35 Response from server: " + client3.receiveResponse());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client3.close();
            }
        });


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }

    private static void phase1() throws InterruptedException {
        System.out.println("\n\nPHASE1\n\n");
        BasicClient client1 = new BasicClient(hostname, port);
        BasicClient client2 = new BasicClient(hostname, port);

        Thread t1 = new Thread(() -> {
            try {
                client1.sendCommand("CREATE__1file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                String responseCreate = client1.receiveResponse();
                System.out.println("11 Response from server: " + responseCreate);

                client1.sendCommand("CREATE__2file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client1.receiveResponse();
                System.out.println("12 Response from server: " + responseCreate);

                client1.sendCommand("CREATE__3file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client1.receiveResponse();
                System.out.println("13 Response from server: " + responseCreate);

                client1.sendCommand("CREATE__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client1.receiveResponse();
                System.out.println("14 Response from server: " + responseCreate);

                client1.sendCommand("CREATE__5file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client1.receiveResponse();
                System.out.println("15 Response from server: " + responseCreate);

                client1.sendCommand("CREATE__6file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client1.receiveResponse();
                System.out.println("16 Response from server: " + responseCreate);

                client1.sendCommand("CREATE__client_WRITE_TEST_file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client1.receiveResponse();
                System.out.println("17 Response from server: " + responseCreate);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client1.close();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                client2.sendCommand("CREATE__7file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                String responseCreate = client2.receiveResponse();
                System.out.println("21 Response from server: " + responseCreate);

                client2.sendCommand("CREATE__1file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client2.receiveResponse();
                System.out.println("22 Response from server: " + responseCreate);

                client2.sendCommand("CREATE__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client2.receiveResponse();
                System.out.println("23 Response from server: " + responseCreate);

                client2.sendCommand("CREATE__4file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client2.receiveResponse();
                System.out.println("24 Response from server: " + responseCreate);

                client2.sendCommand("CREATE__8file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client2.receiveResponse();
                System.out.println("25 Response from server: " + responseCreate);

                client2.sendCommand("CREATE__9file.txt__C:\\Users\\Pouria\\Desktop\\OS_FileManagementing_ServerClient\\files");
                responseCreate = client2.receiveResponse();
                System.out.println("26 Response from server: " + responseCreate);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client2.close();
            }
        });

        t1.start();
        Thread.sleep(2000);
        t2.start();

        t1.join();
        t2.join();
    }
}

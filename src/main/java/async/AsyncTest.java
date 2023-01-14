package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;
import java.util.function.Supplier;
import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1"));

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill"));

  /**
   * 
   * @param ceo_id
   * @return
   *         find a ceo in the list of ceo and
   *         send the function (thread) to asynchronous execution to predict the
   *         future (ouput) value of income function
   */
  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    Supplier<Option<Ceo>> ceoFoundSupplier = () -> {
      return ceos.map(t -> Option.of(t))
          .filter(t -> t.get().id.equals(ceo_id))
          .getOrElse(() -> Option.none());
    };
    CompletableFuture<Option<Ceo>> ceo = CompletableFuture.supplyAsync(ceoFoundSupplier);
    return ceo;
  }

  /**
   * 
   * @param ceo_id
   * @return
   *         find an enterprise the list of entreprise and
   *         send the function (thread) to asynchronous execution to predict the
   *         future (ouput) value of income function
   */
  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    Supplier<Option<Enterprise>> enterpriseFoundSupplier = () -> enterprises.map(enterprise -> Option.of(enterprise))
        .filter(enterprise -> enterprise.get().ceo_id.equals(ceo_id))
        .getOrElse(() -> Option.none());
    CompletableFuture<Option<Enterprise>> enterprise = CompletableFuture.supplyAsync(enterpriseFoundSupplier);
    enterprise.thenAccept(System.out::println);
    return enterprise;
  }

  /**
   * 
   * @param ceo_id
   * @return
   *         return an ceo with is enterprise through tuple
   *         and send to asynchronous execution
   */
  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    Option<Ceo> ceo = ceos.map(t -> Option.of(t))
        .filter(t -> t.get().id.equals(ceo_id))
        .getOrElse(() -> Option.none());

    Option<Enterprise> enterprise = enterprises.map(t -> Option.of(t))
        .filter(t -> t.get().ceo_id.equals(ceo_id))
        .getOrElse(() -> Option.none());

    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> tupleFuture = CompletableFuture.supplyAsync(
        () -> Tuple.of(ceo, enterprise));
    return tupleFuture;
  }

}

package chapter6;

import chapter4.model.Dish;
import java.util.List;
import java.util.stream.Collectors;

public class Ex20_ToListCollectDish {

    public static void main(String[] args) {
//        List<Dish> myDishes = Dish.dishes().stream().parallel().collect(new Ex19_ToListCollector<>());
        List<Dish> myDishes = Dish.dishes().stream().collect(new Ex19_ToListCollector<>());
        System.out.println("myDishes = " + myDishes);

        List<Dish> dishes = Dish.dishes().stream().collect(Collectors.toList());
        System.out.println("dishes = " + dishes);
    }

    /**
     * Ex19_ToListCollector: IDENTITY_FINISH, CONCURRENT
     * List<Dish> myDishes = Dish.dishes().stream().parallel().collect(new Ex19_ToListCollector<>());
     * // 병렬 실행 + 동시 실행(로컬 컨테이너) + 병합 작업 수행(병렬 실행=작업 분리)
     * [1611107785465] accumulator pizza
     * [1611107785465] accumulator beef
     * [1611107785465] accumulator french fries
     * [1611107785465] accumulator prawns
     * [1611107785465] accumulator salmon
     * [1611107785465] accumulator season fruit
     * [1611107785465] accumulator pork
     * [1611107785465] accumulator chicken
     * [1611107785531] accumulator rice
     * [1611107785531] combiner [rice] and [season fruit]
     * [1611107785531] combiner [pork] and [beef]
     * [1611107785531] combiner [chicken] and [french fries]
     * [1611107785531] combiner [prawns] and [salmon]
     * [1611107785578] combiner [pork, beef] and [chicken, french fries]
     * [1611107785578] combiner [pizza] and [prawns, salmon]
     * [1611107785578] combiner [rice, season fruit] and [pizza, prawns, salmon]
     * [1611107785578] combiner [pork, beef, chicken, french fries] and [rice, season fruit, pizza, prawns, salmon]
     *
     * List<Dish> myDishes = Dish.dishes().stream().collect(new Ex19_ToListCollector<>());
     * // 동시 실행(로컬 컨테이너) + 병합 작업 X(작업 분리 X)
     * [1611107848624] accumulator pork
     * [1611107848657] accumulator beef
     * [1611107848657] accumulator chicken
     * [1611107848657] accumulator french fries
     * [1611107848657] accumulator rice
     * [1611107848657] accumulator season fruit
     * [1611107848657] accumulator pizza
     * [1611107848657] accumulator prawns
     * [1611107848657] accumulator salmon
     *
     * Ex19_ToListCollector: IDENTITY_FINISH, UNORDERED, CONCURRENT
     * List<Dish> myDishes = Dish.dishes().stream().parallel().collect(new Ex19_ToListCollector<>());
     * // 병렬 실행 + 동시 실행(공유 컨테이너) + 병합 작업 X(공유 컨테이너)
     * [1611108040030] accumulator beef
     * [1611108040029] accumulator prawns
     * [1611108040028] accumulator season fruit
     * [1611108040030] accumulator salmon
     * [1611108040030] accumulator chicken
     * [1611108040030] accumulator french fries
     * [1611108040029] accumulator rice
     * [1611108040030] accumulator pizza
     * [1611108040100] accumulator pork
     *
     * List<Dish> myDishes = Dish.dishes().stream().collect(new Ex19_ToListCollector<>());
     * 동시 실행 + 병합 작업 X(공유 컨테이너)
     * [1611108083592] accumulator pork
     * [1611108083620] accumulator beef
     * [1611108083620] accumulator chicken
     * [1611108083620] accumulator french fries
     * [1611108083620] accumulator rice
     * [1611108083620] accumulator season fruit
     * [1611108083620] accumulator pizza
     * [1611108083620] accumulator prawns
     * [1611108083620] accumulator salmon
     *
     * Ex19_ToListCollector: IDENTITY_FINISH
     * List<Dish> myDishes = Dish.dishes().stream().parallel().collect(new Ex19_ToListCollector<>());
     * // 병렬 처리 + 병합 작업(작업 분리, 로컬 컨테이너)
     * [1611107959581] accumulator chicken
     * [1611107959581] accumulator prawns
     * [1611107959580] accumulator season fruit
     * [1611107959582] accumulator pizza
     * [1611107959581] accumulator french fries
     * [1611107959581] accumulator beef
     * [1611107959580] accumulator rice
     * [1611107959581] accumulator pork
     * [1611107959667] accumulator salmon
     * [1611107959667] combiner [rice] and [season fruit]
     * [1611107959667] combiner [prawns] and [salmon]
     * [1611107959667] combiner [chicken] and [french fries]
     * [1611107959707] combiner [pizza] and [prawns, salmon]
     * [1611107959667] combiner [pork] and [beef]
     * [1611107959707] combiner [rice, season fruit] and [pizza, prawns, salmon]
     * [1611107959707] combiner [pork, beef] and [chicken, french fries]
     * [1611107959707] combiner [pork, beef, chicken, french fries] and [rice, season fruit, pizza, prawns, salmon]
     *
     * List<Dish> myDishes = Dish.dishes().stream().collect(new Ex19_ToListCollector<>());
     * // 병합 작업 X (작업 분리 X)
     * [1611107896755] accumulator pork
     * [1611107896806] accumulator beef
     * [1611107896806] accumulator chicken
     * [1611107896806] accumulator french fries
     * [1611107896806] accumulator rice
     * [1611107896806] accumulator season fruit
     * [1611107896806] accumulator pizza
     * [1611107896806] accumulator prawns
     * [1611107896806] accumulator salmon
     */
}

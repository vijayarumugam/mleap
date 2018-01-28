package ml.combust.bundle.v07.dsl

import ml.bundle.v07.ModelDef

/** Companion object for model.
  */
object Model {
  /** Create a dsl model from a bundle model.
    *
    * @param modelDef bundle model definition
    * @return dsl model
    */
  def fromBundle(modelDef: ModelDef): Model = Model(op = modelDef.op,
    attributes = modelDef.attributes.map(AttributeList.fromBundle))
}

/** Class that encodes all information need to serialize or deserialize
  * a machine learning model.
  *
  * Models encode things like coefficients for linear regressions,
  * labels for string indexers, sizes for one hot encoders, decision trees,
  * and any other data needed to serialize and deserialize ML models and
  * feature builders.
  *
  * @param op op name for the model
  * @param attributes optional list of attributes for the model
  */
case class Model(op: String,
                 attributes: Option[AttributeList] = None) extends HasAttributeList[Model]